package com.crswty.kind

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import io.reactivex.Observable
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

class TextViewObservableDelegate(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): Observable<String> {

        return Observable.create { emitter ->
            thisRef.findViewById<TextView>(id).addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(p0: Editable) {}

                override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                    emitter.onNext(p0.toString())
                }
            })
        }
    }
}

val ViewDelegate<TextView>.observable : TextViewObservableDelegate
    get() = TextViewObservableDelegate(id)
