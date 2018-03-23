package com.bwei.ssp.mvpretrofitrxjava.bean

/**
 * Created by lenovo on 2018/3/8.
 */
class CategoryBean (val id: Long, val name: String, val description: String, val bgPicture: String, val bgColor: String, val headerImage: String)
//在Kotlin中一些只保存数据的类,称为数据类(data class),
//为了确保自动生成的代码一致性和有意义,数据类(data class)必须满足以下要求:
//主构造函数至少有一个参数;
//主构造函数的所有参数需标记为val 或 var;
//数据类不能是抽象、开放、密封或者内部的;
//自kotlin 1.1起,数据类可以扩展其他类;在1.1之前,数据类只能实现接口 （Serializable）