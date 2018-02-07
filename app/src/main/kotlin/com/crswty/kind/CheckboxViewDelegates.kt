package com.crswty.kind

import android.app.Activity
import android.widget.CheckBox
import kotlin.reflect.KProperty

class CheckboxValueDelegate(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): Boolean {
        return thisRef.findViewById<CheckBox>(id).isChecked
    }

    operator fun setValue(thisRef: Activity, prop: KProperty<*>, value: Boolean) {
        thisRef.findViewById<CheckBox>(id).isChecked = value
    }
}

val ViewDelegate<CheckBox>.value
    get() = CheckboxValueDelegate(id)