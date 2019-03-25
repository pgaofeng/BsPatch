package com.pgaofeng.common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pgaofeng.common.mvp.Presenter;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Fragment
 */
public abstract class BaseFragment<P extends Presenter> extends Fragment implements com.pgaofeng.common.mvp.View {

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        initView(view);
        mPresenter = createPresenter();
        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detach();
        super.onDestroyView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    /**
     * 获取content布局id
     *
     * @return 布局id
     */
    protected abstract int getContentView();

    /**
     * 初始化View
     *
     * @param view contentView
     */
    protected abstract void initView(View view);

    /**
     * 创建View对应的Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

}
