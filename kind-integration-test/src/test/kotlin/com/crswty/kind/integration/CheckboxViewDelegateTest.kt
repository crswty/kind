package com.crswty.kind.integration

import android.widget.CheckBox
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
class CheckboxViewDelegateTest {

    @Test
    fun shouldBindValueToIsChecked() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        val provider = object : TestViewProvider(activity) {
            var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value
        }

        checkBox.isChecked = true
        assertThat(provider.checkboxValue, equalTo(true))

        provider.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldPushCheckChangeEventsToObservable() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        val provider = object : TestViewProvider(activity) {
            val checkboxObservable by bind<CheckBox>(R.id.checkbox_view).value.observable
        }

        val events = mutableListOf<Boolean>()
        provider.checkboxObservable
                .subscribe({ events.add(it) })

        checkBox.isChecked = true
        checkBox.isChecked = false

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo(true))
        assertThat(events[1], equalTo(false))
    }
}