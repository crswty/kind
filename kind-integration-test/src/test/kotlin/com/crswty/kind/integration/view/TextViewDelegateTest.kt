package com.crswty.kind.integration.view

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.delegates.observable
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


    @Test
    fun textView_shouldBindValueToText() {
        open class TextViewActivity : TestActivity<TextView>({ TextView(it) })
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
    fun editText_shouldBindValueToText() {

        class EditTextValue : TestActivity<EditText>({ EditText(it) }) {
            var editTextValue by bind<EditText>(viewId).value
        }

        val activity = Robolectric.setupActivity(EditTextValue::class.java)
        val textView = activity.view

        textView.setText("Expected value")
        assertThat(activity.editTextValue, equalTo("Expected value"))

        activity.editTextValue = "Updated value"
        assertThat(textView.text.toString(), equalTo("Updated value"))
    }

    @Test
    fun shouldPushTextChangeEventsToObservable() {
        open class TextViewActivity : TestActivity<TextView>({ TextView(it) })
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
