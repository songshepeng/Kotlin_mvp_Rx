package com.bwei.ssp.mvpretrofitrxjava.Utlis

/**
 * Created by lenovo on 2018/3/8.
 */
 abstract  class BasePresenter<T :IBaseView>  {
    protected var view : T

    constructor(view:T) {
        this.view =view
        init()
    }
   protected abstract fun init()

}