package com.pgaofeng.common.network;

import com.google.gson.JsonParseException;
import com.pgaofeng.common.bean.BaseData;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 将基本的观察者进行封装
 */
public abstract class BaseObserver<T> extends DisposableObserver<BaseData<T>> {

    protected BaseObserver(DisposableManager disposableManager) {
        disposableManager.addDisposable(this);
    }

    @Override
    public void onNext(BaseData<T> baseData) {
        if (baseData.getCode() == 200) {
            success(baseData);
        } else {
            fail(baseData);
        }
    }

    @Override
    public void onError(Throwable e) {
        BaseData<T> baseData = new BaseData<>();
        if (e instanceof JsonParseException) {
            baseData.setCode(NetWorkConstants.JSON_ERROR_CODE);
            baseData.setMessage(NetWorkConstants.JSON_ERROR_MSG);
        } else if (e instanceof HttpException) {
            baseData.setCode(NetWorkConstants.HTTP_ERROR_CODE);
            baseData.setMessage(NetWorkConstants.HTTP_ERROR_MSG);
        } else {
            baseData.setCode(NetWorkConstants.OTHER_ERROR_CODE);
            baseData.setMessage(NetWorkConstants.OTHER_ERROR_MSG);
        }
        if (NetWorkConstants.DEBUG) {
            e.printStackTrace();
        }

        error(baseData);
    }

    @Override
    public void onComplete() {
    }

    /**
     * 获取数据成功
     *
     * @param baseData 封装的数据
     */
    protected abstract void success(BaseData<T> baseData);

    /**
     * 获取数据失败
     *
     * @param baseData 封装的数据
     */
    protected abstract void fail(BaseData<T> baseData);

    /**
     * 出现了错误
     *
     * @param baseData 封装的数据
     */
    protected abstract void error(BaseData<T> baseData);
}
