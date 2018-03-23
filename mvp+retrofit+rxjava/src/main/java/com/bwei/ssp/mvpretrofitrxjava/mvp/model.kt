package com.bwei.ssp.mvpretrofitrxjava.mvp

import com.bwei.ssp.mvpretrofitrxjava.Utlis.RetrofitManager
import com.bwei.ssp.mvpretrofitrxjava.Utlis.UriConstan

/**
 * Created by lenovo on 2018/3/8.
 */
class model {
    fun getBanner() = RetrofitManager.builder(UriConstan.BASE_URL).service!!.getCategory()
}


