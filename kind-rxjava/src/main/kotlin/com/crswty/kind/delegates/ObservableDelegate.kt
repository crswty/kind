package com.crswty.kind.delegates

import android.view.View
import io.reactivex.Emitter
import io.reactivex.Observable
import kotlin.reflect.KProperty

/**
 * Wrapper to simplify exposing [Observable]s as properties
 */
class ObservableDelegate<in V: View, T>(id: Int, private val callback: (V, Emitter<T>) -> Unit)
    : com.crswty.kind.delegates.ReadPropertyAndroidDelegate<V, Observable<T>>(id) {

    override fun getFromView(view: V, prop: KProperty<*>): Observable<T> {
        return Observable.create { emitter ->
            callback(view, emitter)
        }
    }
}