package com.pgaofeng.basemvp.main.model;

import android.os.Handler;

import com.pgaofeng.basemvp.main.contract.MainContract;
import com.pgaofeng.basemvp.service.MainService;
import com.pgaofeng.common.base.BaseModel;
import com.pgaofeng.common.bean.BaseData;
import com.pgaofeng.common.callback.ModelCallBack;
import com.pgaofeng.common.network.BaseObserver;
import com.pgaofeng.common.network.DisposableManager;
import com.pgaofeng.common.network.RetrofitClient;


/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description :主界面的Model层，用于提供获取数据，主要作用是将获取到的数据转换成对象后通过回调交由Presenter
 */
public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public void getTextString(String param, ModelCallBack callBack, Handler handler) {
        RetrofitClient.getInstance()
                .createService(MainService.class)
                .getTextViewText(param)
                .compose(switchThread())
                .subscribe(new BaseObserver<String>(mDisposableManager) {
                    @Override
                    protected void success(BaseData<String> baseData) {
                        callBack.success(baseData);
                    }

                    @Override
                    protected void fail(BaseData<String> baseData) {
                        callBack.success(baseData);
                    }

                    @Override
                    protected void error(BaseData<String> baseData) {
                        callBack.success(baseData);
                    }
                });
    }
}
