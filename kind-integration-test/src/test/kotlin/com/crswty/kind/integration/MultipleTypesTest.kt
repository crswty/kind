package com.crswty.kind.integration

import android.app.Activity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.value
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MultipleTypesTest {

    @Test
    fun shouldBindToValueOfComponentsWithDifferentTypes() {
        class ActivityWithMultipleViews : Activity() {
            val textViewValue by bind<TextView>(0).value
            val checkBoxValue by bind<CheckBox>(1).value

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                val layout = LinearLayout(this)
                val textView = TextView(this).also { it.id = 0; it.text = "Expected value" }
                val checkBox = CheckBox(this).also { it.id = 1; it.isChecked = true }
                layout.addView(textView)
                layout.addView(checkBox)
                setContentView(layout)
            }
        }


        val activity = Robolectric.setupActivity(ActivityWithMultipleViews::class.java)

        assertThat(activity.textViewValue, equalTo("Expected value"))
        assertThat(activity.checkBoxValue, equalTo(true))
    }
}