package com.bwei.ssp.mvpretrofitrxjava.Adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by lenovo on 2018/3/9.
 */
class ViewHoder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    private var mView: SparseArray<View>?=null
    init {
        mView = SparseArray()
    }
    fun <T : View> getView(viewId: Int): T {
        //对已有的view做缓存
        var view: View? = mView?.get(viewId)
        //使用缓存的方式减少findViewById的次数
        if (view == null) {
            view = itemView.findViewById(viewId)
            mView?.put(viewId, view)
        }
        return view as T
    }
    fun <T : ViewGroup> getViewGroup(viewId: Int): T {
        //对已有的view做缓存
        var view: View? = mView?.get(viewId)
        //使用缓存的方式减少findViewById的次数
        if (view == null) {
            view = itemView.findViewById(viewId)
            mView?.put(viewId, view)
        }
        return view as T
    }

    fun setText(viewId: Int, text: CharSequence): ViewHoder {
        val view = getView<TextView>(viewId)
        view.text = "" + text
        //希望可以链式调用
        return this
    }

    fun setImageResource(viewId: Int, resId: Int): ViewHoder {
        val iv = getView<ImageView>(viewId)
        iv.setImageResource(resId)
        return this
    }


    fun setImagePath(viewId: Int, imageLoader: HolderImageLoader): ViewHoder {
        val iv = getView<ImageView>(viewId)
        imageLoader.loadImage(iv, imageLoader.path)
        return this
    }

    abstract class HolderImageLoader(val path: String) {

        /**
         * 需要去复写这个方法加载图片
         *
         * @param iv
         * @param path
         */
        abstract fun loadImage(iv: ImageView, path: String)
    }
    fun setOnItemClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }
    fun setOnItemLongClickListener(listener: View.OnLongClickListener) {
        itemView.setOnLongClickListener(listener)
    }

}