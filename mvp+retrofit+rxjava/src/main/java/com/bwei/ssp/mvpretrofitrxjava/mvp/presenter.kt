package com.bwei.ssp.mvpretrofitrxjava.mvp

import com.bwei.ssp.mvpretrofitrxjava.Utlis.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by lenovo on 2018/3/8.
 */
class presenter(view: view) : BasePresenter<view>(view) {
    var model: model? = null
    override fun init() {
        model = model()
    }
    fun getData(){
        val categoryData = model!!.getBanner()
        categoryData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    dksdg -> view.showCategory(dksdg)
                }){ throwable -> println(throwable.message) }
    }

}