package com.crswty.kind

import android.app.Activity
import android.app.Fragment
import android.view.View
import android.widget.TextView
import kotlin.reflect.KProperty


abstract class ReadPropertyAndroidDelegate<in V : View, out R>(val id: Int) {

    operator fun getValue(thisRef: Activity, prop: KProperty<*>): R {
        return getFromView(thisRef.findViewById(id), prop)
    }

    abstract fun getFromView(view: V, prop: KProperty<*>): R
}

abstract class ReadWritePropertyAndroidDelegate<in V : View, R>(id: Int)
    : ReadPropertyAndroidDelegate<V, R>(id) {

    operator fun setValue(thisRef: Activity, prop: KProperty<*>, value: R) {
        setOnView(thisRef.findViewById(id), prop, value)
    }

    abstract fun setOnView(view: V, prop: KProperty<*>, value: R)
}