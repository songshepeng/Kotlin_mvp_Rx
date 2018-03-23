package com.bwei.ssp.mvpretrofitrxjava.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by lenovo on 2018/3/9.
 */
abstract class BaseAdapter<T>(var mContext: Context, var mData: ArrayList<T>,private var mLayoutId: Int ): RecyclerView.Adapter<ViewHoder>() {
    protected var mInflater: LayoutInflater? = null
    private var mItemClickListener: OnItemClickListener? = null

    //使用接口回调点击事件
    private var mItemLongClickListener: OnItemLongclickListener? = null
    init {
        mInflater = LayoutInflater.from(mContext)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        //创建view
        val view = mInflater?.inflate(mLayoutId, parent, false)
        return ViewHoder(view!!)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        //绑定数据
        bindData(holder, mData[position], position)
        mItemClickListener?.let {
            //let 默认返回最后一个执行的对象
            holder.itemView.setOnClickListener { mItemClickListener!!.onItemClick(mData[position], position) }
        }

        //长按点击事件
        mItemLongClickListener?.let {
            holder.itemView.setOnLongClickListener { mItemLongClickListener!!.onItemLongClick(mData[position], position) }
        }
    }
    protected abstract fun bindData(holder: ViewHoder, data: T, position: Int)
    override fun getItemCount(): Int {
        return mData.size
    }
    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

    fun setOnItemLongClickListener(itemLongClickListener: OnItemLongclickListener) {
        this.mItemLongClickListener = itemLongClickListener
    }

}