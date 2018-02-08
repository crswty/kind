package com.crswty.kind

import android.os.Bundle
import android.widget.CheckBox
import com.crswty.kind.activity.R
import com.crswty.kind.fragment.CheckboxCompatFragment
import com.crswty.kind.fragment.TestFragment
import com.crswty.kind.view.TestView
import org.hamcrest.Matchers
import org.hamcrest.Matchers.equalTo
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@RunWith(RobolectricTestRunner::class)
class ViewTest {

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


}