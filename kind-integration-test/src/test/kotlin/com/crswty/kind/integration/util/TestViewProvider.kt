package com.crswty.kind.integration.util

import android.app.Activity
import android.view.View
import com.crswty.kind.ViewProvider

open class TestViewProvider(val activity: Activity): ViewProvider {
    override fun <T : View> findViewById(id: Int) = activity.findViewById<T>(id)
}