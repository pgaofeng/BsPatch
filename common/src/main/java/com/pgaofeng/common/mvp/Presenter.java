package com.pgaofeng.common.mvp;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : MVP 框架的Presenter基础接口
 */
public interface Presenter {
    /**
     * 解除关联
     */
    void detach();

    /**
     * 判断View是否与当前的Presenter建立连接
     *
     * @return true为已建立连接
     */
    boolean isAttach();

    /**
     * 检查是否与View建立连接
     */
    void checkAttach();
}
