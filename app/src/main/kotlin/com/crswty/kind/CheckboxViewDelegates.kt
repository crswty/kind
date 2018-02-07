package com.crswty.kind

import android.widget.CheckBox
import kotlin.reflect.KProperty


class CheckboxValueDelegate(id: Int): ReadWritePropertyAndroidDelegate<CheckBox, Boolean>(id) {

    override fun getFromView(view: CheckBox, prop: KProperty<*>) = view.isChecked

    override fun setOnView(view: CheckBox, prop: KProperty<*>, value: Boolean) {
        view.isChecked = value
    }

    val observable = ObservableDelegate<CheckBox, Boolean>(id) { view, emitter ->
        view.setOnCheckedChangeListener{ _, newValue: Boolean ->
            emitter.onNext(newValue)
        }
    }
}

val ViewDelegate<CheckBox>.value
    get() = CheckboxValueDelegate(id)


