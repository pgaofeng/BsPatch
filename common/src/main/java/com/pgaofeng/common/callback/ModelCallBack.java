package com.pgaofeng.common.callback;

import com.pgaofeng.common.bean.BaseData;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : Model层数据请求的Callback
 */
public interface ModelCallBack<T> {
    /**
     * 请求成功的回调
     *
     * @param baseData 返回值的基础bean
     */
    void success(BaseData<T> baseData);

    /**
     * 请求失败的回调
     *
     * @param baseData 返回值的基础bean
     */
    void fail(BaseData<T> baseData);

    /**
     * 请求出错的回调
     *
     * @param baseData 返回值的基础bean
     */
    void error(BaseData<T> baseData);

}
