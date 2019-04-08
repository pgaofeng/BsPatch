package com.pgaofeng.basemvp.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author gaofengpeng
 * @date 2019/3/27
 * @description : 用于提供网络的初始化
 */
public class RetrofitClient {

    /**
     * Retrofit实例，用于创建service
     */
    private Retrofit mRetrofit;
    /**
     * Retrofit单实例，用于单例模式
     */
    private static RetrofitClient mRetrofitClient;

    private RetrofitClient() {
        init();
    }

    /**
     * 获取RetrofitClient的单例
     *
     * @return RetrofitClient实例
     */
    public static RetrofitClient getInstance() {
        if (mRetrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (mRetrofitClient == null) {
                    mRetrofitClient = new RetrofitClient();
                }
            }
        }
        return mRetrofitClient;
    }


    /**
     * 初始化Retrofit
     */
    private void init() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.example.com");

        mRetrofit = retrofitBuilder.client(clientBuilder.build()).build();
    }

    /**
     * 产生对应的Service
     *
     * @param tClass Service的class类型
     * @param <T>    泛型
     * @return Service实例
     */
    public <T> T createService(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }

}
