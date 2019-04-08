package com.pgaofeng.basemvp.main;

import android.text.TextUtils;

import com.google.gson.JsonParseException;
import com.pgaofeng.common.base.BasePresenter;
import com.pgaofeng.common.bean.BaseData;
import com.pgaofeng.common.callback.ModelCallBack;

import java.util.Random;

import retrofit2.HttpException;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :主界面的主持类，主要作用是将Model获取的数据进行一系列的处理，然后通知View更新界面
 */
public class MainPresenter extends BasePresenter<MainActivity, MainModel> implements MainContract.Presenter {
    MainPresenter(MainActivity view) {
        super(view);
    }

    private String[] params = {"success", "fail"};
    private Random random = new Random(System.currentTimeMillis());

    @Override
    protected MainModel createModel() {
        return new MainModel();
    }


    @Override
    public void updateTextViewText() {
        // 请求开始时显示进度条
        mView.showProgress();

        // 模拟获取数据的几种状态，这里通过传递的参数来决定是否获取数据成功
        int index = random.nextInt(2);

        mModel.getTextString(params[index], new ModelCallBack() {
                    @Override
                    public void success(BaseData<?> baseData) {
                        checkAttach();
                        String s = (String) baseData.getData();
                        if (!TextUtils.isEmpty(s)) {
                            mView.updateText((String) baseData.getData());
                        }
                        mView.hideProgress();
                        mView.showToast(baseData.getMessage());
                    }

                    @Override
                    public void fail(Throwable throwable) {
                        checkAttach();
                        // 检查错误信息，该部分可放到BaseObserver中
                        String errorMsg ;
                        if (throwable instanceof JsonParseException) {
                            errorMsg = "Json解析失败！";
                        } else if (throwable instanceof HttpException) {
                            errorMsg = "Http错误！";
                        } else {
                            errorMsg = "其他错误！";
                        }


                        mView.showToast(errorMsg);
                        mView.hideProgress();
                    }
                }

        );
    }
}
