package com.bwei.ssp.mvpretrofitrxjava

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.bwei.ssp.mvpretrofitrxjava.Adapter.CategoryAdapter
import com.bwei.ssp.mvpretrofitrxjava.bean.CategoryBean
import com.bwei.ssp.mvpretrofitrxjava.mvp.presenter
import com.bwei.ssp.mvpretrofitrxjava.mvp.view
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), view{
    private var mCategoryList = ArrayList<CategoryBean>()
    var mAdapter: CategoryAdapter? = null
    var int:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = presenter(this)

        presenter.getData()
         mAdapter =CategoryAdapter(this, mCategoryList, R.layout.item)
         mRecyclerView.layoutManager = GridLayoutManager(this,2)
         mRecyclerView.adapter = mAdapter
    }
    override fun showError(errorMsg: String, errorCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.e("**",errorMsg+"***")
    }

    override fun showCategory(bean: ArrayList<CategoryBean>) {
        mCategoryList =bean
        mAdapter!!.setData(mCategoryList)
        Log.e("**",bean.size.toString()+"***")
    }
}
