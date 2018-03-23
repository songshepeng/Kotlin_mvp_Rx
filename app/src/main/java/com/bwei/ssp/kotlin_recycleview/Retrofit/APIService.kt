package com.bwei.ssp.kotlin_recycleview.Retrofit

import com.bwei.ssp.kotlin_recycleview.bean.Banner
import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

/**
 * Created by lenovo on 2018/3/6.
 */
interface APIService {
    @Headers("Cache-Control: public, max-age=60 * 60 * 24 * 7")
    @GET("/course_api/banner/query?type=1")
    fun getHot(): Observable<List<Banner>>
}