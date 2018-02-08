package com.crswty.kind

import android.os.Bundle
import android.widget.CheckBox
import com.crswty.kind.activity.R
import com.crswty.kind.fragment.CheckboxCompatFragment
import com.crswty.kind.fragment.TestFragment
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@RunWith(RobolectricTestRunner::class)
class FragmentTest {

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

}