package com.crswty.kind

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlin.reflect.KProperty

class TextViewValueDelegate(id: Int): ReadWritePropertyAndroidDelegate<TextView, String>(id) {

    override fun getFromView(view: TextView, prop: KProperty<*>) = view.text.toString()

    override fun setOnView(view: TextView, prop: KProperty<*>, value: String) {
        view.text = value
    }

    val observable = ObservableDelegate<TextView, String>(id) { view, emitter ->
        view.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {}

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                emitter.onNext(p0.toString())
            }
        })
    }

}

val ViewDelegate<TextView>.value
    get() = TextViewValueDelegate(id)

