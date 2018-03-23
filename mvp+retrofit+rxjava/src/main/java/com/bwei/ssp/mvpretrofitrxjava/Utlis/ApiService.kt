package com.bwei.ssp.mvpretrofitrxjava.Utlis

import com.bwei.ssp.mvpretrofitrxjava.bean.CategoryBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by lenovo on 2018/3/8.
 */
interface ApiService {
    @GET("v4/categories")
    fun getCategory():Observable<ArrayList<CategoryBean>>

}