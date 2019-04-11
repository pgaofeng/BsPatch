package com.pgaofeng.basemvp.main.model;

import android.os.Handler;
import android.util.Log;

import com.pgaofeng.basemvp.main.contract.MainContract;
import com.pgaofeng.common.base.BaseModel;
import com.pgaofeng.common.bean.BaseData;
import com.pgaofeng.common.callback.ModelCallBack;


/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :主界面的Model层，用于提供获取数据，主要作用是将获取到的数据转换成对象后通过回调交由Presenter
 */
public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public void getTextString(final String param, final ModelCallBack callBack, Handler handler) {
        if (callBack == null) {
            throw new RuntimeException("回调不应为空");
        }
        new Thread(() -> {
            try {
                // 模拟在子线程中获取数据
                Thread.sleep(2000);
                // 获取数据结束结束后切换主线程回调
                handler.post(() -> {
                    BaseData<String> baseData = new BaseData<>();
                    switch (param) {
                        case "success":
                            baseData.setCode(0);
                            baseData.setMessage("获取成功");
                            baseData.setData("我是获取到的消息内容");
                            callBack.success(baseData);
                            break;
                        case "fail":
                            callBack.fail(new RuntimeException("人为异常！"));
                            break;
                        default:
                            break;
                    }
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
