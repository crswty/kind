package com.crswty.kind

import android.widget.CheckBox
import com.crswty.kind.activity.CheckboxViewActivity
import com.crswty.kind.activity.R
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasSize
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CheckboxViewDelegateTest {

    @Test
    fun shouldBindValueToIsChecked() {
        val activity = Robolectric.setupActivity(CheckboxViewActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldPushCheckChangeEventsToObservable() {
        val activity = Robolectric.setupActivity(CheckboxViewActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        val events = mutableListOf<Boolean>()
        activity.checkboxObservable
                .subscribe({ events.add(it) })

        checkBox.isChecked = true
        checkBox.isChecked = false

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo(true))
        assertThat(events[1], equalTo(false))
    }
}