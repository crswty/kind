package com.crswty.kind

import android.widget.TextView
import com.crswty.kind.activity.R
import com.crswty.kind.activity.TextViewActivity
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class TextViewDelegateTest {


    @Test
    fun shouldBindToTextView() {
        val activity = Robolectric.setupActivity(TextViewActivity::class.java)
        val textView = activity.findViewById<TextView>(R.id.text_view)

        assertThat(activity.textView, equalTo(textView))
    }

    @Test
    fun shouldBindToTextViewValue() {
        val activity = Robolectric.setupActivity(TextViewActivity::class.java)
        val textView = activity.findViewById<TextView>(R.id.text_view)

        textView.text = "Expected value"
        assertThat(activity.textViewValue, equalTo("Expected value"))

        activity.textViewValue = "Updated value"
        assertThat(textView.text.toString(), equalTo("Updated value"))
    }
}
