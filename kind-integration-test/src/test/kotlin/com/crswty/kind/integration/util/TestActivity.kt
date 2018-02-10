package com.crswty.kind.integration.util

import android.app.Activity
import android.os.Bundle
import android.view.View


open class TestActivity<T : View>(private val create: (Activity) -> T) : Activity() {
    var viewId = 0
    lateinit var view: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = create(this).also { it.id = viewId }
        this.setContentView(view)
    }
}