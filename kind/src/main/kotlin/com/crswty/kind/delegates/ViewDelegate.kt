package com.crswty.kind.delegates

import android.view.View
import kotlin.reflect.KProperty


/**
 * [ViewDelegate] provides the view which has the given ID
 * @param V The View which is expected to be returned
 * @param id the ID of the view which will be bound to
 * @see com.crswty.kind.bind
 */
class ViewDelegate<V : View>(id: Int): ReadPropertyAndroidDelegate<V, V>(id) {
    override fun getFromView(view: V, prop: KProperty<*>) = view
}