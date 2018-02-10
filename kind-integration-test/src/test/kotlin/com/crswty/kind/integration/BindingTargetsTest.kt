package com.crswty.kind.integration

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.crswty.kind.ViewProvider
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.CustomWidgetsActivity
import com.crswty.kind.integration.activity.R
import com.crswty.kind.integration.activity.StandardWidgetsActivity
import com.crswty.kind.integration.fragment.CompatabilityFragment
import com.crswty.kind.integration.fragment.StandardFragment
import com.crswty.kind.integration.view.CustomView
import com.crswty.kind.value
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@RunWith(RobolectricTestRunner::class)
class BindingTargetsTest {

    @Test
    fun shouldBindToActivity() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindToFragment() {
        val fragment = Robolectric.buildFragment(StandardFragment::class.java).create(Bundle()).get()
        val checkBox = fragment.view.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        fragment.checkboxValue

        checkBox.isChecked = true
        assertThat(fragment.checkboxValue, equalTo(true))

        fragment.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindToCompatFragment() {
        val fragment = CompatabilityFragment()
        SupportFragmentTestUtil.startFragment(fragment)

        val checkBox = fragment.view!!.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        fragment.checkboxValue

        checkBox.isChecked = true
        assertThat(fragment.checkboxValue, equalTo(true))

        fragment.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }


    @Test
    fun shouldBindToView() {
        val activity = Robolectric.setupActivity(CustomWidgetsActivity::class.java)
        val customView = activity.findViewById<CustomView>(R.id.test_view)

        val nestedCheckBox = customView.findViewById<CheckBox>(R.id.nested_checkbox_view)

        nestedCheckBox.isChecked = true
        customView.nestedCheckboxValue

        nestedCheckBox.isChecked = true
        assertThat(customView.nestedCheckboxValue, equalTo(true))

        customView.nestedCheckboxValue = false
        assertThat(nestedCheckBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindToViewProvider() {

        val fragment = Robolectric.buildFragment(StandardFragment::class.java).create(Bundle()).get()

        val viewProvider = object : ViewProvider {
            var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value
            override fun <T : View> findViewById(id: Int) = fragment.view.findViewById<T>(id)
        }

        val nestedCheckBox = fragment.view.findViewById<CheckBox>(R.id.checkbox_view)

        nestedCheckBox.isChecked = true
        viewProvider.checkboxValue

        nestedCheckBox.isChecked = true
        assertThat(viewProvider.checkboxValue, equalTo(true))

        viewProvider.checkboxValue = false
        assertThat(nestedCheckBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindMultipleComponents() {
        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)

        val textView = activity.findViewById<TextView>(R.id.text_view)
        textView.text = "Expected value"
        assertThat(activity.textViewValue, equalTo("Expected value"))

        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)
        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))
    }
}