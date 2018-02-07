package com.crswty.kind

import android.widget.CheckBox
import android.widget.TextView
import com.crswty.kind.activity.MixedViewActivity
import com.crswty.kind.activity.R
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MixedActivityTest {

    @Test
    fun shouldBindDifferentTypesOfValues() {
        val activity = Robolectric.setupActivity(MixedViewActivity::class.java)

        val textView = activity.findViewById<TextView>(R.id.text_view)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        textView.text = "Expected value"
        assertThat(activity.textViewValue, equalTo("Expected value"))

        activity.textViewValue = "Updated value"
        assertThat(textView.text.toString(), equalTo("Updated value"))

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }
}