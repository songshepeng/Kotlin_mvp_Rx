package com.bwei.ssp.kotlin_recycleview.adaper

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bwei.ssp.kotlin_recycleview.R

/**
 * Created by lenovo on 2018/3/6.
 */
class MyHoder(itemView: View, click: OnItemClick?):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    var textView: TextView
    var img: ImageView
    private var click: OnItemClick? = null
    init {
        textView = itemView.findViewOften(R.id.textview)
        img = itemView.findViewOften(R.id.img)
        this.click = click
        itemView.setOnClickListener(this)
    }
    fun <T :View> View.findViewOften(viewId: Int): T {
        var viewHolder: SparseArray<View> = tag as? SparseArray<View> ?:SparseArray()
        tag = viewHolder
        var childView: View? = viewHolder.get(viewId)
        if (null == childView) {
            childView = findViewById(viewId)
            viewHolder.put(viewId, childView)
        }
        return childView as T
    }
   // findViewOften是适配器优化的方法 由于 Kotlin 提供类型推断功能，所以 findViewOften 的返回值不用手动转换或者手动指定泛型类型。
    override fun onClick(v: View?) {
      if (v!=null){
          click!!.onItemClick(v, adapterPosition)
      }
    }
    //override重写父类的方法关键字
}