package com.pgaofeng.common.network;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 网络配置的常量
 */
public final class NetWorkConstants {
    /**
     * 读取超时时间，秒
     */
    static int READ_TIMEOUT = 20;
    /**
     * 写入超时时间，秒
     */
    static int WRITE_TIMEOUT = 20;

    /**
     * 连接超时时间，秒
     */
    static int CONNECT_TIMEOUT = 20;

    /**
     * 开启Debug模式
     */
    static boolean DEBUG = true;

    /**
     * 网络请求错误原因
     */
    static int JSON_ERROR_CODE = -1;
    static String JSON_ERROR_MSG = "Json 解析出错";

    static int HTTP_ERROR_CODE = -2;
    static String HTTP_ERROR_MSG = "网络连接出错";

    static int OTHER_ERROR_CODE = -3;
    static String OTHER_ERROR_MSG = "其他错误";
}
