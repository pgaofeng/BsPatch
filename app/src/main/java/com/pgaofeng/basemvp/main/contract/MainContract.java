package com.pgaofeng.basemvp.main.contract;

import android.os.Handler;

import com.pgaofeng.common.callback.ModelCallBack;


/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 主界面的契约接口，用于整合View，Presenter和Model
 */
public interface MainContract {
    interface View {
        /**
         * 更新TextView的text
         *
         * @param text 内容
         */
        void updateText(String text);

        /**
         * 显示Toast
         *
         * @param message 消息内容分
         */
        void showToast(String message);
    }

    interface Presenter {
        /**
         * 更新TextView的内容
         */
        void updateTextViewText();
    }

    interface Model {
        /**
         * 获取TextView 的内容
         *
         * @param param    请求参数
         * @param callBack 请求回调
         */
        void getTextString(String param, ModelCallBack callBack);
    }
}
