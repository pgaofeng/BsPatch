package com.pgaofeng.common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.pgaofeng.common.mvp.Presenter;
import com.pgaofeng.common.mvp.View;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Activity
 */
public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity implements View {
    protected P mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mPresenter = createPresenter();
        initView();
        mProgressDialog = new ProgressDialog(this);

        new ProgressBar(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.hide();
    }

    /**
     * 返回Content布局id
     *
     * @return 布局文件id
     */
    protected abstract int getContentView();

    /**
     * View的初始化工作
     */
    protected abstract void initView();

    /**
     * 创建Presenter
     *
     * @return 与Activity关联的Presenter
     */
    protected abstract P createPresenter();
}
