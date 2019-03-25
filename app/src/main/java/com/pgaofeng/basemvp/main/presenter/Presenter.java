package com.pgaofeng.basemvp.main.presenter;

import android.os.Handler;

import com.pgaofeng.basemvp.main.contract.Contract;
import com.pgaofeng.basemvp.main.view.MainActivity;
import com.pgaofeng.common.base.BasePresenter;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :
 */
public class Presenter extends BasePresenter<MainActivity> implements Contract.Presenter {
    public Presenter(MainActivity view) {
        super(view);
    }

    @Override
    public void updateTextViewText() {
        mView.showProgress();
        new Handler().postDelayed(() -> {
            if (isAttach()) {
                mView.updateText("获取到的消息");
                mView.hideProgress();
            }
        }, 2000);
    }
}
