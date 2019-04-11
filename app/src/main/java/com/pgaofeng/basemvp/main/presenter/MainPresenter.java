package com.pgaofeng.basemvp.main.presenter;

import android.os.Handler;
import android.text.TextUtils;

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
 * @description :主界面的主持类，主要作用是将Model获取的数据进行一系列的处理，然后通知View更新界面
 */
public class MainPresenter extends BasePresenter<MainActivity, MainModel> implements MainContract.Presenter {
    public MainPresenter(MainActivity view, Handler handler) {
        super(view);
        this.mHandler = handler;
    }

    private String[] params = {"success", "fail"};
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
        int index = random.nextInt(2);

        mModel.getTextString(params[index], new ModelCallBack() {
            @Override
            public void success(BaseData<?> baseData) {
                checkAttach();
                String s = (String) baseData.getData();
                if (!TextUtils.isEmpty(s)) {
                    mView.updateText(s);
                }
                mView.hideProgress();
                mView.showToast(baseData.getMessage());
            }

            @Override
            public void fail(Throwable throwable) {

                checkAttach();
                mView.showToast("获取数据失败！");
                mView.hideProgress();
            }
        }, mHandler);
    }
}
