package com.crswty.kind.delegates

import android.widget.CheckBox
import kotlin.reflect.KProperty

/**
 * Binds the property to [CheckBox.isChecked] and [CheckBox.setChecked]
 * @see com.crswty.kind.value
 */
class CheckboxValueDelegate(id: Int): ReadWritePropertyAndroidDelegate<CheckBox, Boolean>(id) {

    override fun getFromView(view: CheckBox, prop: KProperty<*>) = view.isChecked

    override fun setOnView(view: CheckBox, prop: KProperty<*>, value: Boolean) {
        view.isChecked = value
    }


}
