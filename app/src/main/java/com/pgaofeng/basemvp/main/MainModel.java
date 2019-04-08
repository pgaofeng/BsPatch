package com.pgaofeng.basemvp.main;

import android.os.Handler;

import com.pgaofeng.basemvp.network.RetrofitClient;
import com.pgaofeng.basemvp.service.MainService;
import com.pgaofeng.common.base.BaseModel;
import com.pgaofeng.common.bean.BaseData;
import com.pgaofeng.common.callback.ModelCallBack;
import com.pgaofeng.common.network.BaseObserver;


/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :主界面的Model层，用于提供获取数据，主要作用是将获取到的数据转换成对象后通过回调交由Presenter
 */
public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public void getTextString(String param, ModelCallBack callBack) {

        RetrofitClient.getInstance()
                .createService(MainService.class)
                .getTextViewText(param)
                .compose(switchThread())
                .subscribe(new BaseObserver<BaseData<String>>(mDisposableManager) {
                    @Override
                    public void onNext(BaseData<String> stringBaseData) {
                        callBack.success(stringBaseData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //callBack.fail(e);

                        /*
                         * 由于请求的链接并不存在，最终的结果将会返回到onError这里
                         * 因此，这里将模拟成功和失败的情况
                         * 另外又加入2秒延迟代表请求的过程
                         */
                        new Handler().postDelayed(() -> {
                            if ("success".equals(param)) {
                                BaseData<String> baseData = new BaseData<>();
                                baseData.setMessage("获取数据成功！");
                                baseData.setData("我是获取的数据");
                                callBack.success(baseData);
                            } else {
                                callBack.fail(e);
                            }
                        }, 2000);

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
