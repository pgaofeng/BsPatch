package com.pgaofeng.common.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pgaofeng.common.dialog.DialogUtils;
import com.pgaofeng.common.mvp.Presenter;
import com.pgaofeng.common.mvp.View;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Fragment
 */
public abstract class BaseFragment<P extends Presenter> extends Fragment implements View {

    protected P mPresenter;
    private Dialog mDialog;
    protected Context mContext;

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(getContentView(), container, false);
        initView(view);
        mPresenter = createPresenter();
        mContext = getContext();
        mDialog = DialogUtils.getDefaultDialog(mContext);
        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detach();
        super.onDestroyView();
    }

    @Override
    public void showProgress() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    /**
     * 获取content布局id
     *
     * @return 布局id
     */
    protected abstract @LayoutRes int getContentView();

    /**
     * 初始化View
     *
     * @param view contentView
     */
    protected abstract void initView(android.view.View view);

    /**
     * 创建View对应的Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

}
