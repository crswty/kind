package com.crswty.kind.integration

import android.view.View
import com.crswty.kind.bind
import com.crswty.kind.integration.util.TestActivity
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasSize
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ViewDelegateTest {

    open class ViewActivity : TestActivity<View>({ View(it) })

    @Test
    fun shouldPushClickEventsToObservable() {

        class ClickObservableActivity : ViewActivity() {
            val clickObservable by bind<View>(viewId).clickObservable
        }

        val activity = Robolectric.setupActivity(ClickObservableActivity::class.java)

        val events = mutableListOf<View>()
        activity.clickObservable
                .subscribe({ events.add(it) })

        val view = activity.view
        view.performClick()
        view.performClick()

        assertThat(events, hasSize(2))
        assertThat(events[0], equalTo(view))
        assertThat(events[1], equalTo(view))
    }

}

