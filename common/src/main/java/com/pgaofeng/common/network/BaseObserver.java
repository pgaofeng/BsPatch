package com.pgaofeng.common.network;

import io.reactivex.observers.DisposableObserver;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 将基本的观察者进行封装
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {

    protected BaseObserver(DisposableManager disposableManager) {
        disposableManager.addDisposable(this);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public void onComplete() {
    }

    /**
     * 数据成功返回的回调
     *
     * @param t 获取到的数据
     */
    public abstract void onSuccess(T t);

    /**
     * 请求数据出现错误的回调
     *
     * @param throwable 异常信息
     */
    public abstract void onFail(Throwable throwable);
}
