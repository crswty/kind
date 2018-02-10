package com.crswty.kind.integration

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.crswty.kind.ViewProvider
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.CustomWidgetsActivity
import com.crswty.kind.integration.activity.R
import com.crswty.kind.integration.activity.StandardWidgetsActivity
import com.crswty.kind.integration.fragment.CompatabilityFragment
import com.crswty.kind.integration.fragment.StandardFragment
import com.crswty.kind.integration.view.CustomView
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

        assertThat(activity.checkbox, equalTo(checkBox))
    }

    @Test
    fun shouldBindToFragment() {
        val fragment = Robolectric.buildFragment(StandardFragment::class.java).create(Bundle()).get()
        val checkBox = fragment.view.findViewById<CheckBox>(R.id.checkbox_view)

        assertThat(fragment.checkBox, equalTo(checkBox))
    }

    @Test
    fun shouldBindToCompatabilityFragment() {
        val fragment = CompatabilityFragment()
        SupportFragmentTestUtil.startFragment(fragment)

        val checkBox = fragment.view!!.findViewById<CheckBox>(R.id.checkbox_view)

        assertThat(fragment.checkBox, equalTo(checkBox))
    }


    @Test
    fun shouldBindToView() {
        val activity = Robolectric.setupActivity(CustomWidgetsActivity::class.java)
        val customView = activity.findViewById<CustomView>(R.id.test_view)

        val nestedCheckBox = customView.findViewById<CheckBox>(R.id.nested_checkbox_view)

        assertThat(customView.nestedCheckbox, equalTo(nestedCheckBox))
    }

    @Test
    fun shouldBindToViewProvider() {

        val activity = Robolectric.setupActivity(StandardWidgetsActivity::class.java)

        val viewProvider = object : ViewProvider {
            val checkBox by bind<CheckBox>(R.id.checkbox_view)
            override fun <T : View> findViewById(id: Int) = activity.findViewById<T>(id)
        }

        val nestedCheckBox = activity.findViewById<CheckBox>(R.id.checkbox_view)
        assertThat(viewProvider.checkBox, equalTo(nestedCheckBox))
    }

}