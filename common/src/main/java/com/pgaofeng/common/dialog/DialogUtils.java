package com.pgaofeng.common.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : dialog工具，用于提供对话框或者进度条
 */
public class DialogUtils {

    /**
     * 用于生成默认的正在加载的进度条，该进度条用于普通加载时显示
     *
     * @return 对话框
     */
    public static Dialog getDefaultDialog(Context context) {
        Dialog dialog = new ProgressDialog(context);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
