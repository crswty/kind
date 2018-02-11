package com.crswty.kind.delegates

import android.widget.TextView
import kotlin.reflect.KProperty

/**
 * Binds the property to [TextView.getText] and [TextView.setText]
 * @see com.crswty.kind.value
 */
class TextViewValueDelegate(id: Int): ReadWritePropertyAndroidDelegate<TextView, String>(id) {

    override fun getFromView(view: TextView, prop: KProperty<*>) = view.text.toString()

    override fun setOnView(view: TextView, prop: KProperty<*>, value: String) {
        view.text = value
    }

}

