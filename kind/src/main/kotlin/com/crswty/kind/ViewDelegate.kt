package com.crswty.kind

import android.view.View
import io.reactivex.Emitter
import io.reactivex.Observable
import kotlin.reflect.KProperty

class ViewDelegate<V : View>(id: Int): ReadPropertyAndroidDelegate<V, V>(id) {
    override fun getFromView(view: V, prop: KProperty<*>) = view

    val clickObservable = ObservableDelegate<View, Unit>(id) { view, emitter ->
        view.setOnClickListener {
            emitter.onNext(Unit)
        }
    }

}

fun <T : View> bind(id: Int): ViewDelegate<T> {
    return ViewDelegate(id)
}

class ObservableDelegate<in V: View, T>(id: Int, private val callback: (V, Emitter<T>) -> Unit)
    : ReadPropertyAndroidDelegate<V, Observable<T>>(id) {

    override fun getFromView(view: V, prop: KProperty<*>): Observable<T> {
        return Observable.create { emitter ->
            callback(view, emitter)
        }
    }
}
