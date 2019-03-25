package com.pgaofeng.basemvp.main.presenter;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.pgaofeng.basemvp.main.contract.MainContract;
import com.pgaofeng.basemvp.main.model.MainModel;
import com.pgaofeng.basemvp.main.view.MainActivity;
import com.pgaofeng.common.base.BasePresenter;
import com.pgaofeng.common.bean.BaseData;
import com.pgaofeng.common.callback.ModelCallBack;

import java.util.Random;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :
 */
public class MainPresenter extends BasePresenter<MainActivity, MainModel> implements MainContract.Presenter {
    public MainPresenter(MainActivity view, Handler handler) {
        super(view);
        this.mHandler = handler;
    }

    private String[] params = {"success", "fail", "error"};
    private Handler mHandler;
    private Random random = new Random(System.currentTimeMillis());

    @Override
    protected MainModel createModel() {
        return new MainModel();
    }


    @Override
    public void updateTextViewText() {
        mView.showProgress();

        // 模拟获取数据的几种状态，这里通过参数来决定是否获取数据成功
        int index = random.nextInt(3);
        mModel.getTextString(params[index], new ModelCallBack<String>() {
            @Override
            public void success(BaseData<String> baseData) {
                String s = baseData.getData();
                if (!TextUtils.isEmpty(s)) {
                    mView.updateText(baseData.getData());
                }
                mView.hideProgress();
                mView.showToast(baseData.getMessage());
            }

            @Override
            public void fail(BaseData<String> baseData) {
                mView.showToast(baseData.getMessage());
                mView.hideProgress();
                Toast.makeText(mView, baseData.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(BaseData<String> baseData) {
                mView.showToast(baseData.getMessage());
                mView.hideProgress();
            }
        }, mHandler);
    }
}
