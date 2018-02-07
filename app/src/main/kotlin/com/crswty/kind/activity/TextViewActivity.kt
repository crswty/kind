package com.crswty.kind.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.crswty.kind.bind
import com.crswty.kind.value

class TextViewActivity : AppCompatActivity() {

    val textView by bind<TextView>(R.id.text_view)
    var textViewValue by bind<TextView>(R.id.text_view).value
    val textViewObservable by bind<TextView>(R.id.text_view).value.observable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
    }


}
