package com.crswty.kind

import android.app.Activity
import android.view.View
import kotlin.reflect.KProperty

class ViewDelegate<out T : View>(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): T {
        return thisRef.findViewById(id)
    }

}

fun <T : View> bind(id: Int): ViewDelegate<T> {
    return ViewDelegate(id)
}