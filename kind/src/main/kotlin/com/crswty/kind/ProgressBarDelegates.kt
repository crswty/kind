package com.crswty.kind

import android.support.v4.widget.ContentLoadingProgressBar
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.SeekBar
import kotlin.reflect.KProperty

class ProgressBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<ProgressBar, Int>(id) {

    override fun getFromView(view: ProgressBar, prop: KProperty<*>) = view.progress

    override fun setOnView(view: ProgressBar, prop: KProperty<*>, value: Int) {
        view.progress = value
    }
}

class RatingBarDelegate(id: Int) : ReadWritePropertyAndroidDelegate<RatingBar, Int>(id) {

    override fun getFromView(view: RatingBar, prop: KProperty<*>) = view.numStars

    override fun setOnView(view: RatingBar, prop: KProperty<*>, value: Int) {
        view.numStars = value
    }
}

//val ViewDelegate<ProgressBar>.value
//    @JvmName("progressBarValue")
//    get() = ProgressBarDelegate(id)

val ViewDelegate<ContentLoadingProgressBar>.value
    @JvmName("contentLoadingProgressBarValue")
    get() = ProgressBarDelegate(id)

val ViewDelegate<SeekBar>.value
    @JvmName("seekBarValue")
    get() = ProgressBarDelegate(id)

val ViewDelegate<RatingBar>.value
    @JvmName("ratingBarValue")
    get() = RatingBarDelegate(id)