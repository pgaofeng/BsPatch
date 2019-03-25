package com.pgaofeng.common.mvp;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : MVP框架的View基础接口
 */
public interface View {
    /**
     * 显示进度条，用于提示正在加载
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hideProgress();

}
