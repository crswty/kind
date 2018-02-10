package com.crswty.kind.integration.view

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import com.crswty.kind.bind
import com.crswty.kind.integration.activity.R

class CustomView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    val nestedCheckbox by bind<CheckBox>(R.id.nested_checkbox_view)

}

