package com.crswty.kind.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.crswty.kind.activity.R
import com.crswty.kind.bind
import com.crswty.kind.value


class TestFragment : Fragment() {

    var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_checkbox, container, false)
    }
}


class CheckboxCompatFragment : android.support.v4.app.Fragment() {

    var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_checkbox, container, false)
    }
}
