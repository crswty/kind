package com.crswty.kind

import android.support.v4.widget.ContentLoadingProgressBar
import android.view.View
import android.widget.*
import com.crswty.kind.delegates.*

/**
 * # Binding to Views
 *
 * Creates a new instance of [ViewDelegate] which delegates this property to
 * the view with the provided ID, for example:
 *
 * ```
 *
 * class MyActivity: Activity() {
 *     val checkBox by bind<CheckBox>(R.id.yes_no_checkbox)
 * }
 * ```
 *
 * # Binding to Values
 *
 * Kind also allows for binding to properties of views, most often this means binding to to the
 * 'value' of the view, for example, rather than binding to a check boxes view, a property can bind
 * to the the value of that check box. This provides an easy way to see if it is checked or not and
 * also to check/un-check it.
 *
 *
 * ```
 *
 * class MyActivity: Activity() {
 *     var checkBoxValue by bind<CheckBox>(R.id.yes_no_checkbox).value
 * }
 * ```
 *
 *
 * @param id the ID of the view which will be bound to
 *
 */
fun <T : View> bind(id: Int): ViewDelegate<T> {
    return ViewDelegate(id)
}

/**
 * Binds the property to [TextView.getText] and [TextView.setText]
 */
val ViewDelegate<out TextView>.value
    get() = TextViewValueDelegate(id)

/**
 * Binds the property to [CheckBox.isChecked] and [CheckBox.setChecked]
 */
val ViewDelegate<CheckBox>.value
    get() = CheckboxValueDelegate(id)

/**
 * Binds the property to [ProgressBar.getProgress] and
 * [ProgressBar.setProgress]
 */
val ViewDelegate<out ProgressBar>.value
    get() = ProgressBarDelegate(id)

/**
 * Binds the property to [android.widget.RatingBar.getNumStars] and
 * [android.widget.RatingBar.getNumStars]
 */
val ViewDelegate<RatingBar>.numStars
    get() = RatingBarDelegate(id)
