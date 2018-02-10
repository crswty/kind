package com.crswty.kind.integration.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CheckBox
import com.crswty.kind.bind

class StandardWidgetsActivity : AppCompatActivity() {

    val checkbox by bind<CheckBox>(R.id.checkbox_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_standard_widgets)
    }


}