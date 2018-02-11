package com.crswty.kind.delegates

import android.view.View
import kotlin.reflect.KProperty


class ViewDelegate<V : View>(id: Int): ReadPropertyAndroidDelegate<V, V>(id) {
    override fun getFromView(view: V, prop: KProperty<*>) = view

    val clickObservable = ObservableDelegate<V, V>(id) { view, emitter ->
        view.setOnClickListener { view ->
            @Suppress("UNCHECKED_CAST")
            emitter.onNext(view as V)
        }
    }

}