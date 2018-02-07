package com.crswty.kind.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CheckBox
import com.crswty.kind.bind
import com.crswty.kind.value

class CheckboxViewActivity : AppCompatActivity() {

    val checkbox by bind<CheckBox>(R.id.checkbox_view)
    var checkboxValue by bind<CheckBox>(R.id.checkbox_view).value
    val checkboxObservable by bind<CheckBox>(R.id.checkbox_view).value.observable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_view)
    }



}