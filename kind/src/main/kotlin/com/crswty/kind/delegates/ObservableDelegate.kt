package com.crswty.kind.delegates

import android.view.View
import io.reactivex.Emitter
import io.reactivex.Observable
import kotlin.reflect.KProperty

class ObservableDelegate<in V: View, T>(id: Int, private val callback: (V, Emitter<T>) -> Unit)
    : ReadPropertyAndroidDelegate<V, Observable<T>>(id) {

    override fun getFromView(view: V, prop: KProperty<*>): Observable<T> {
        return Observable.create { emitter ->
            callback(view, emitter)
        }
    }
}