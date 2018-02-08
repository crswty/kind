package com.crswty.kind.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.value

class TestActivity : AppCompatActivity() {

    var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value
    var textViewValue by bind<TextView>(R.id.text_view).value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mixed_view)
    }


}