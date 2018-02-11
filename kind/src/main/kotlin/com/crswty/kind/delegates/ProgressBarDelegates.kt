package com.crswty.kind.delegates

import android.widget.ProgressBar
import android.widget.RatingBar
import kotlin.reflect.KProperty

/**
 * Binds the property to [ProgressBar.getProgress] and
 * [ProgressBar.setProgress]
 * @see com.crswty.kind.value
 */
open class ProgressBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<ProgressBar, Int>(id) {

    override fun getFromView(view: ProgressBar, prop: KProperty<*>) = view.progress

    override fun setOnView(view: ProgressBar, prop: KProperty<*>, value: Int) {
        view.progress = value
    }
}

/**
 * Binds the property to [RatingBar.getNumStars] and [RatingBar.setNumStars]
 * @see com.crswty.kind.value
 */
class RatingBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<RatingBar, Int>(id) {

    override fun getFromView(view: RatingBar, prop: KProperty<*>) = view.numStars

    override fun setOnView(view: RatingBar, prop: KProperty<*>, value: Int) {
        view.numStars = value
    }
}