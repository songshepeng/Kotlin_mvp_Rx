package com.bwei.ssp.mvpretrofitrxjava.Adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bwei.ssp.mvpretrofitrxjava.R
import com.bwei.ssp.mvpretrofitrxjava.bean.CategoryBean

/**
 * Created by lenovo on 2018/3/9.
 */
class CategoryAdapter(mContext: Context, categoryList: ArrayList<CategoryBean>, layoutId: Int):BaseAdapter<CategoryBean>(mContext, categoryList, layoutId) {

    /**
     * 设置新数据
     */
    fun setData(categoryList: ArrayList<CategoryBean>){
        mData.clear()
        mData = categoryList
        notifyDataSetChanged()
    }

    /**
     * 绑定数据
     */
    override fun bindData(holder: ViewHoder, data: CategoryBean, position: Int) {
        holder.setImagePath(R.id.iv_category, object : ViewHoder.HolderImageLoader(data.bgPicture) {
            override fun loadImage(iv: ImageView, path: String) {
                Glide.with(mContext)
                        .load(path)
                        .placeholder(R.mipmap.ic_launcher)
                        .thumbnail(0.5f)
                        .into(iv)
            }
        })

        holder.setText(R.id.tv_category_name, "#${data.name}")
        holder.setOnItemClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(mContext,"sss",Toast.LENGTH_LONG).show()
            }
        })

    }
}