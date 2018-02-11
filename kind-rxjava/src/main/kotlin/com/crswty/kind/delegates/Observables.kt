package com.crswty.kind.delegates

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

val <V : View> ViewDelegate<V>.clickObservable
    get() = ObservableDelegate<V, V>(id) { view, emitter ->
        view.setOnClickListener { clickedView ->
            @Suppress("UNCHECKED_CAST")
            emitter.onNext(clickedView as V)
        }
    }

val CheckboxValueDelegate.observable
    get() = ObservableDelegate<CheckBox, Boolean>(id) { view, emitter ->
        view.setOnCheckedChangeListener { _, newValue: Boolean ->
            emitter.onNext(newValue)
        }
    }

val TextViewValueDelegate.observable
    get() = ObservableDelegate<TextView, String>(id) { view, emitter ->
        view.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {}

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                emitter.onNext(p0.toString())
            }
        })
    }