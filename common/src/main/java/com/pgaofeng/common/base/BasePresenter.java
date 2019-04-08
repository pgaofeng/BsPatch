package com.pgaofeng.common.base;

import com.pgaofeng.common.mvp.Model;
import com.pgaofeng.common.mvp.Presenter;
import com.pgaofeng.common.mvp.View;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Presenter
 */
public abstract class BasePresenter<V extends View, M extends Model> implements Presenter {
    protected V mView;
    protected M mModel;

    public BasePresenter(V view) {
        mView = view;
        mModel = createModel();
    }

    @Override
    public void detach() {
        mView = null;
        mModel.removeDisposable();
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void checkAttach() {
        if (!isAttach()){
            throw new RuntimeException("当前Presenter未与View建立连接");
        }
    }

    /**
     * 创建Presenter对应的Model
     *
     * @return Model
     */
    protected abstract M createModel();
}
