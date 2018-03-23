package com.bwei.ssp.mvpretrofitrxjava.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates

/**
 * Created by lenovo on 2018/3/8.
 */
class Myapplication : Application() {

    companion object {

        private val TAG = "MyApplication"
        var context: Context by Delegates.notNull()
            private set
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        context = applicationContext
        //ApplicationContext的主要实现类是ClassPathXmlApplicationContext和FileSystemXmlApplicationContext，前者默认从类路径加载配置文件，后者默认从文件系统中装载配置文件
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    //registerActivityLifecycleCallbacks是Application的一个接口，注册之后应用里的所有activity的生命周期都会被监控起来，我们可以在

   // 此接口方法里实现一些特殊的需求。比如统计用户对每个Activity使用情况，我们可以定义一个BaseActivity，在onStart()和onStop()人工插入统计方法。比如从桌面进应用的时候，检测某些状态，就可以在onActivityResumed方法里检测

    private val mActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }
    }

}