package com.bwei.ssp.kotlin_recycleview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bwei.ssp.kotlin_recycleview.Retrofit.RetrofitManager
import com.bwei.ssp.kotlin_recycleview.adaper.MyAdapter
import com.bwei.ssp.kotlin_recycleview.adaper.OnItemClick
import com.bwei.ssp.kotlin_recycleview.bean.Banner
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() ,OnItemClick{


    private var data = ArrayList<Banner>()
    private var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MyAdapter()
        text_list.layoutManager = LinearLayoutManager(this)
        getBanner()
        adapter!!.setItemClick(this)
    }

    fun getBanner() {
        RetrofitManager.builder("http://112.124.22.238:8081")
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { println("call…………………………") }
                .subscribe({ dvcx ->
                    println(dvcx.toString())
                    adapter!!.add(dvcx)
                    text_list.adapter = adapter
                }) { throwable -> println(throwable.message) }

    }

    override fun onItemClick(view: View, positon: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(applicationContext, "我是第" + positon + "个", Toast.LENGTH_SHORT).show()

    }
}


