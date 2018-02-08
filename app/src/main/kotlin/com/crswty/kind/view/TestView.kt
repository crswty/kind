package com.crswty.kind.view

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import com.crswty.kind.activity.R
import com.crswty.kind.bind
import com.crswty.kind.value

class TestView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var nestedCheckboxValue by bind<CheckBox>(R.id.nested_checkbox_view).value

}

