package com.bwei.ssp.kotlin_recycleview.adaper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bwei.ssp.kotlin_recycleview.MyApplication
import com.bwei.ssp.kotlin_recycleview.R
import com.bwei.ssp.kotlin_recycleview.bean.Banner

/**
 * Created by lenovo on 2018/3/6.
 */
class MyAdapter :RecyclerView.Adapter<MyHoder>(){
    var list: List<Banner> = ArrayList<Banner>()
    var click: OnItemClick? = null
    fun add(list: List<Banner>) {
        this.list = list
    }
    //添加数据
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHoder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false)
        val holder = MyHoder(view, null)
        return holder
    }
    override fun onBindViewHolder(holder: MyHoder?, position: Int) {
        if (holder != null) {
            holder.textView.text = list!![position].name
            Glide.with(MyApplication.getInstance())
                    .load(list[position].imgUrl)
                    .centerCrop()
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.img)
        }
    }
    override fun getItemCount(): Int {
        return list?.size as Int
    }
    fun setItemClick(click: OnItemClick) {
        this.click = click
    }
}