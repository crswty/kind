package com.crswty.kind

import android.widget.CheckBox
import com.crswty.kind.activity.CheckboxViewActivity
import com.crswty.kind.activity.R
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CheckboxViewDelegateTest {


    @Test
    fun shouldBindToCheckboxView() {
        val activity = Robolectric.setupActivity(CheckboxViewActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        assertThat(activity.checkbox, equalTo(checkBox))
    }

    @Test
    fun shouldBindToCheckboxViewValue() {
        val activity = Robolectric.setupActivity(CheckboxViewActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }
}