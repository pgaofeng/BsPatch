package com.pgaofeng.common.base;

import com.pgaofeng.common.mvp.Model;
import com.pgaofeng.common.network.DisposableManager;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 基础Model
 */
public class BaseModel implements Model {

    protected DisposableManager mDisposableManager;

    public BaseModel() {
        this.mDisposableManager = new DisposableManager();
    }

    /**
     * 数据请求切换线程，io线程请求数据，请求完后在主线程进行操作
     *
     * @param <T> 泛型，应当是BaseData<?>
     * @return 转换后的结果
     */
    @Override
    public <T> ObservableTransformer<T, T> switchThread() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void removeDisposable() {
        mDisposableManager.clearDisposable();
    }
}
