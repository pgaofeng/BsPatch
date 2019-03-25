package com.pgaofeng.basemvp.main.contract;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 主界面的契约接口
 */
public interface Contract {
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
}
