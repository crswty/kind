package com.crswty.kind

import android.app.Activity
import android.widget.TextView
import kotlin.reflect.KProperty

class TextViewValueDelegate(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): String {
        return thisRef.findViewById<TextView>(id).text.toString()
    }

    operator fun setValue(thisRef: Activity, prop: KProperty<*>, value: String) {
        thisRef.findViewById<TextView>(id).text = value
    }
}

val ViewDelegate<TextView>.value
    get() = TextViewValueDelegate(id)
