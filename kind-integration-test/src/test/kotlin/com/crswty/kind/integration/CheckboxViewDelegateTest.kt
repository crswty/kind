package com.crswty.kind.integration

import android.widget.CheckBox
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.R
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
class CheckboxViewDelegateTest {

    open class CheckboxActivity: TestActivity<CheckBox>({ CheckBox(it) })

    @Test
    fun shouldBindValueToIsChecked() {

        class CheckboxActivityValue: CheckboxActivity() {
            var checkboxValue by bind<CheckBox>(viewId).value
        }

        val activity = Robolectric.setupActivity(CheckboxActivityValue::class.java)
        val checkBox = activity.view

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldPushCheckChangeEventsToObservable() {
        class CheckboxActivityValue: CheckboxActivity() {
            val checkboxObservable by bind<CheckBox>(viewId).value.observable
        }

        val activity = Robolectric.setupActivity(CheckboxActivityValue::class.java)
        val checkBox = activity.view

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