package com.bwei.ssp.kotlin_recycleview.Retrofit

import com.bwei.ssp.kotlin_recycleview.bean.Banner
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by lenovo on 2018/3/6.
 */
 class RetrofitManager private constructor(url: String){
   // var mOkHttpClient: OkHttpClient? = null
    var service: APIService? = null

    init {
        var retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(APIService::class.java)//动态代理
    }
//    kotlin中的类定义同时也是构造函数，这个时候是不能进行操作的，所以kotlin增加了一个新的关键字init用来处理类的初始化问题，
//    init模块中的内容可以直接使用构造函数的参数。
    companion object {
        fun builder(url: String): RetrofitManager {
            println(RetrofitManager.javaClass.classes)
            return RetrofitManager(url)
        }
    }

//    companion关键字仅有这个用法，companion object只能在类中使用，
//    相当于java中的静态内部类（kotlin没有static关键字）
fun getBanner(): Observable<List<Banner>> = service!!.getHot()
    //获取请求的数据
}