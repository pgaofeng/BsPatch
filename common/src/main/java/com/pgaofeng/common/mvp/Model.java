package com.pgaofeng.common.mvp;

import io.reactivex.ObservableTransformer;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : MVP框架的Model基础接口
 */
public interface Model {
    /**
     * 数据请求切换线程
     *
     * @return ObservableTransformer
     */
    <T> ObservableTransformer<T, T> switchThread();

    /**
     * 移除所有网络请求
     */
    void removeDisposable();
}
