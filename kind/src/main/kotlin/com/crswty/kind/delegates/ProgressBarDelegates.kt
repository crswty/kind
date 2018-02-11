package com.crswty.kind.delegates

import android.widget.ProgressBar
import android.widget.RatingBar
import kotlin.reflect.KProperty

open class ProgressBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<ProgressBar, Int>(id) {

    override fun getFromView(view: ProgressBar, prop: KProperty<*>) = view.progress

    override fun setOnView(view: ProgressBar, prop: KProperty<*>, value: Int) {
        view.progress = value
    }
}

class SeekBarDelegate(id: Int) : ProgressBarDelegate(id)
class ContentLoadingProgressBarDelegate(id: Int) : ProgressBarDelegate(id)

class RatingBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<RatingBar, Int>(id) {

    override fun getFromView(view: RatingBar, prop: KProperty<*>) = view.numStars

    override fun setOnView(view: RatingBar, prop: KProperty<*>, value: Int) {
        view.numStars = value
    }
}