package com.crswty.kind.integration

import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.integration.util.TestActivity
import com.crswty.kind.value
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasSize
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class TextViewDelegateTest {

    open class TextViewActivity : TestActivity<TextView>({ TextView(it) })

    @Test
    fun shouldBindValueToText() {

        class TextViewValue : TextViewActivity() {
            var textViewValue by bind<TextView>(viewId).value
        }

        val activity = Robolectric.setupActivity(TextViewValue::class.java)
        val textView = activity.view

        textView.text = "Expected value"
        assertThat(activity.textViewValue, equalTo("Expected value"))

        activity.textViewValue = "Updated value"
        assertThat(textView.text.toString(), equalTo("Updated value"))
    }

    @Test
    fun shouldPushTextChanceEventsToObservable() {
        class TextViewValue : TextViewActivity() {
            val textViewObservable by bind<TextView>(viewId).value.observable
        }

        val activity = Robolectric.setupActivity(TextViewValue::class.java)
        val textView = activity.view

        val events = mutableListOf<String>()
        activity.textViewObservable
                .subscribe({ events.add(it) })

        textView.text = "a"
        textView.text = "b"

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo("a"))
        assertThat(events[1], equalTo("b"))
    }
}
