package com.crswty.kind.integration

import android.widget.CheckBox
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.R
import com.crswty.kind.integration.activity.StandardWidgetsActivity
import com.crswty.kind.integration.util.TestViewProvider
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasSize
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ViewDelegateTest {

    @Test
    fun shouldPushClickEventsToObservable() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)

        val provider = object : TestViewProvider(activity) {
            val clickObservable by bind<CheckBox>(R.id.checkbox_view).clickObservable
        }
        val textView = activity.findViewById<CheckBox>(R.id.checkbox_view)

        val events = mutableListOf<CheckBox>()
        provider.clickObservable
                .subscribe({ events.add(it) })

        textView.performClick()
        textView.performClick()

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo(textView))
        assertThat(events[1], equalTo(textView))
    }
}

