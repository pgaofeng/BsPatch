package com.pgaofeng.basemvp.service;

import com.pgaofeng.common.bean.BaseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : Retrofit的service，用于网络请求
 */
public interface MainService {

    @GET("/api")
    Observable<BaseData<String>> getTextViewText(@Query("id") String id);

}
