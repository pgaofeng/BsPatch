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
}
