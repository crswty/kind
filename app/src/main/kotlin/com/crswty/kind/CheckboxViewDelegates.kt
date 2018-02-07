package com.crswty.kind

import android.app.Activity
import android.widget.CheckBox
import io.reactivex.Observable
import kotlin.reflect.KProperty



class CheckboxValueDelegate(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): Boolean {
        return thisRef.findViewById<CheckBox>(id).isChecked
    }

    operator fun setValue(thisRef: Activity, prop: KProperty<*>, value: Boolean) {
        thisRef.findViewById<CheckBox>(id).isChecked = value
    }

    val observable = CheckboxObservableDelegate(id)
}

val ViewDelegate<CheckBox>.value
    get() = CheckboxValueDelegate(id)


class CheckboxObservableDelegate(val id: Int) {
    operator fun getValue(thisRef: Activity, prop: KProperty<*>): Observable<Boolean> {

        return Observable.create { emitter ->
            thisRef.findViewById<CheckBox>(id).setOnCheckedChangeListener{ _, newValue: Boolean ->
                emitter.onNext(newValue)
            }
        }
    }
}

