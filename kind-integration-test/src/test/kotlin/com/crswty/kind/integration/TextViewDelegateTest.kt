package com.crswty.kind.integration

import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.R
import com.crswty.kind.integration.activity.StandardWidgetsActivity
import com.crswty.kind.integration.util.TestViewProvider
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


    @Test
    fun shouldBindValueToText() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)
        val textView = activity.findViewById<TextView>(R.id.text_view)

        val provider = object : TestViewProvider(activity) {
            var textViewValue by bind<TextView>(R.id.text_view).value
        }

        textView.text = "Expected value"
        assertThat(provider.textViewValue, equalTo("Expected value"))

        provider.textViewValue = "Updated value"
        assertThat(textView.text.toString(), equalTo("Updated value"))
    }

    @Test
    fun shouldPushTextChanceEventsToObservable() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)
        val textView = activity.findViewById<TextView>(R.id.text_view)

        val provider = object : TestViewProvider(activity) {
            val textViewObservable by bind<TextView>(R.id.text_view).value.observable
        }

        val events = mutableListOf<String>()
        provider.textViewObservable
                .subscribe({ events.add(it) })

        textView.text = "a"
        textView.text = "b"

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo("a"))
        assertThat(events[1], equalTo("b"))
    }
}
