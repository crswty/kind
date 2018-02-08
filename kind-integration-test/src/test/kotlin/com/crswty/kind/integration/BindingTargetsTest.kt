package com.crswty.kind.integration

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import com.crswty.kind.integration.activity.TestActivity
import com.crswty.kind.integration.activity.R
import com.crswty.kind.integration.fragment.CheckboxCompatFragment
import com.crswty.kind.integration.fragment.TestFragment
import com.crswty.kind.integration.view.TestView
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
        val activity = Robolectric.setupActivity(TestActivity::class.java)
        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)

        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))

        activity.checkboxValue = false
        assertThat(checkBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindToFragment() {
        val fragment = Robolectric.buildFragment(TestFragment::class.java).create(Bundle()).get()
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
        val fragment = CheckboxCompatFragment()
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
        val fragment = Robolectric.buildFragment(TestFragment::class.java).create(Bundle()).get()
        val testView = fragment.view.findViewById<TestView>(R.id.test_view)

        val nestedCheckBox = testView.findViewById<CheckBox>(R.id.nested_checkbox_view)

        nestedCheckBox.isChecked = true
        testView.nestedCheckboxValue

        nestedCheckBox.isChecked = true
        assertThat(testView.nestedCheckboxValue, equalTo(true))

        testView.nestedCheckboxValue = false
        assertThat(nestedCheckBox.isChecked, equalTo(false))
    }

    @Test
    fun shouldBindMultipleComponents() {
        val activity = Robolectric.setupActivity(TestActivity::class.java)

        val textView = activity.findViewById<TextView>(R.id.text_view)
        textView.text = "Expected value"
        assertThat(activity.textViewValue, equalTo("Expected value"))

        val checkBox = activity.findViewById<CheckBox>(R.id.checkbox_view)
        checkBox.isChecked = true
        assertThat(activity.checkboxValue, equalTo(true))
    }
}