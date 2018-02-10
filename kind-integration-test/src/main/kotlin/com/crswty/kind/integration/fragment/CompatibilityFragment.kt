package com.crswty.kind.integration.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.R

class CompatibilityFragment : android.support.v4.app.Fragment() {

    val checkBox by bind<CheckBox>(R.id.checkbox_view)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_standard_widgets, container, false)
    }
}