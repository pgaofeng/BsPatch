package com.pgaofeng.common.network;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 用于管理网络请求的disposable
 */
public class DisposableManager {
    /**
     * 管理所有的请求
     */
    private CompositeDisposable mCompositeDisposable;


    /**
     * 将请求对象添加进来，用于统一管理
     *
     * @param disposable 具体请求
     */
    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (!mCompositeDisposable.isDisposed() && disposable != null) {
            mCompositeDisposable.add(disposable);
        }
    }

    /**
     * 移除所有的请求并结束
     */
    public void clearDisposable() {
        if (mCompositeDisposable.isDisposed()) {
            return;
        }
        mCompositeDisposable.clear();
    }


}
