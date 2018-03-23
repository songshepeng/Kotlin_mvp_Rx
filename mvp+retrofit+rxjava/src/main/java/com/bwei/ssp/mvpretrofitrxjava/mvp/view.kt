package com.bwei.ssp.mvpretrofitrxjava.mvp

import com.bwei.ssp.mvpretrofitrxjava.Utlis.IBaseView
import com.bwei.ssp.mvpretrofitrxjava.bean.CategoryBean

/**
 * Created by lenovo on 2018/3/8.
 */
interface view :IBaseView{
        /**
         * 显示分类的信息
         */
        fun showCategory(bean: ArrayList<CategoryBean>)

        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String,errorCode:Int)

}