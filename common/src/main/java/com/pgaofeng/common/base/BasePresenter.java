package com.pgaofeng.common.base;

import com.pgaofeng.common.mvp.Presenter;
import com.pgaofeng.common.mvp.View;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Presenter
 */
public class BasePresenter<V extends View> implements Presenter {
    protected V mView;

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }
}
