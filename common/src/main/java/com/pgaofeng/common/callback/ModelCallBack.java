package com.pgaofeng.common.callback;

import com.pgaofeng.common.bean.BaseData;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : Model层数据请求的Callback
 */
public interface ModelCallBack {
    /**
     * 请求成功的回调
     *
     * @param baseData 返回值的基础bean
     */
    void success(BaseData<?> baseData);

    /**
     * @param throwable 异常信息
     */
    void fail(Throwable throwable);

}
