package com.crswty.kind.delegates

import android.app.Activity
import android.view.View
import kotlin.reflect.KProperty

/**
 * Implementors are able to find views and can therefore be used with Kind
 */
interface ViewProvider {
    fun <T : View> findViewById(id: Int): T
}

/**
 * Abstract Delegate that allows subclasses to be bound to an [Activity]/[Fragment]/[View]/[ViewProvider]
 * * for immutable properties
 */
abstract class ReadPropertyAndroidDelegate<in V : View, out R>(val id: Int) {

    operator fun getValue(thisRef: Activity, prop: KProperty<*>): R {
        return getFromView(thisRef.findViewById(id), prop)
    }

    operator fun getValue(thisRef: android.app.Fragment, prop: KProperty<*>): R {
        return getValue(thisRef.view, prop)
    }

    operator fun getValue(thisRef: android.support.v4.app.Fragment, prop: KProperty<*>): R {
        return getValue(thisRef.view!!, prop)
    }

    operator fun getValue(thisRef: View, prop: KProperty<*>): R {
        return getFromView(thisRef.findViewById(id), prop)
    }

    operator fun getValue(thisRef: ViewProvider, prop: KProperty<*>): R {
        return getFromView(thisRef.findViewById(id), prop)
    }

    abstract fun getFromView(view: V, prop: KProperty<*>): R
}

/**
 * Abstract Delegate that allows subclasses to be bound to an [Activity]/[Fragment]/[View]/[ViewProvider]
 * for mutable properties
 */
abstract class ReadWritePropertyAndroidDelegate<in V : View, R>(id: Int)
    : ReadPropertyAndroidDelegate<V, R>(id) {

    operator fun setValue(thisRef: Activity, prop: KProperty<*>, value: R) {
        setOnView(thisRef.findViewById(id), prop, value)
    }

    operator fun setValue(thisRef: android.app.Fragment, prop: KProperty<*>, value: R) {
        setValue(thisRef.view, prop, value)
    }

    operator fun setValue(thisRef: android.support.v4.app.Fragment, prop: KProperty<*>, value: R) {
        setValue(thisRef.view!!, prop, value)
    }

    operator fun setValue(thisRef: View, prop: KProperty<*>, value: R) {
        setOnView(thisRef.findViewById(id), prop, value)
    }

    operator fun setValue(thisRef: ViewProvider, prop: KProperty<*>, value: R) {
        setOnView(thisRef.findViewById(id), prop, value)
    }

    abstract fun setOnView(view: V, prop: KProperty<*>, value: R)
}