package com.pgaofeng.basemvp.network;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 切换线程
 */
public class RxManager {
    /**
     * 用于切换线程
     *
     * @return Observable
     */
    public static ObservableTransformer switchThread() {
        return upstream -> upstream
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
