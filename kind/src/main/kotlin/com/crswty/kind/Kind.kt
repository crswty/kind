package com.crswty.kind

import android.support.v4.widget.ContentLoadingProgressBar
import android.view.View
import android.widget.*
import com.crswty.kind.delegates.*

fun <T : View> bind(id: Int): ViewDelegate<T> {
    return ViewDelegate(id)
}

val ViewDelegate<TextView>.value
    get() = TextViewValueDelegate(id)

val ViewDelegate<CheckBox>.value
    get() = CheckboxValueDelegate(id)

//val ViewDelegate<ProgressBar>.value
//    get() = ProgressBarDelegate(id)

val ViewDelegate<ContentLoadingProgressBar>.value
    get() = ContentLoadingProgressBarDelegate(id)

val ViewDelegate<SeekBar>.value
    get() = SeekBarDelegate(id)

val ViewDelegate<RatingBar>.value
    get() = RatingBarDelegate(id)
