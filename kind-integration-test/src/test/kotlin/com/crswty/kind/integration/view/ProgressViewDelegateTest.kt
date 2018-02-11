package com.crswty.kind.integration.view

import android.support.v4.widget.ContentLoadingProgressBar
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.SeekBar
import com.crswty.kind.bind
import com.crswty.kind.integration.util.TestActivity
import com.crswty.kind.value
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ProgressViewDelegateTest {


//    @Test
//    fun progressBar_shouldBindValueToProgress() {
//
//        open class ProgressBarActivity : TestActivity<ProgressBar>({ ProgressBar(it) })
//        class ProgressBarValue : ProgressBarActivity() {
//            var progressBarValue by bind<ProgressBar>(viewId).value
//        }
//
//        val activity = Robolectric.setupActivity(ProgressBarValue::class.java)
//        val progressBar = activity.view
//        progressBar.max = 100
//
//        progressBar.progress = 55
//        assertThat(activity.progressBarValue, equalTo(55))
//
//        activity.progressBarValue = 60
//        assertThat(progressBar.progress, equalTo(60))
//    }

    @Test
    fun contentLoadingProgressBar_shouldBindValueToProgress() {

        open class ProgressBarActivity : TestActivity<ContentLoadingProgressBar>({ ContentLoadingProgressBar(it) })
        class ContentLoadingProgressBarValue : ProgressBarActivity() {
            var progressBarValue by bind<ContentLoadingProgressBar>(viewId).value
        }

        val activity = Robolectric.setupActivity(ContentLoadingProgressBarValue::class.java)
        val progressBar = activity.view

        progressBar.progress = 55
        assertThat(activity.progressBarValue, equalTo(55))

        activity.progressBarValue = 60
        assertThat(progressBar.progress, equalTo(60))
    }

    @Test
    fun seekBar_shouldBindValueToProgress() {

        open class ProgressBarActivity : TestActivity<SeekBar>({ SeekBar(it) })
        class SeekBarValue : ProgressBarActivity() {
            var progressBarValue by bind<SeekBar>(viewId).value
        }

        val activity = Robolectric.setupActivity(SeekBarValue::class.java)
        val progressBar = activity.view

        progressBar.progress = 55
        assertThat(activity.progressBarValue, equalTo(55))

        activity.progressBarValue = 60
        assertThat(progressBar.progress, equalTo(60))
    }

    @Test
    fun ratingBar_shouldBindValueToNumberOfStars() {

        open class ProgressBarActivity : TestActivity<RatingBar>({ RatingBar(it) })
        class RatingBarValue : ProgressBarActivity() {
            var numStarsValue by bind<RatingBar>(viewId).value
        }

        val activity = Robolectric.setupActivity(RatingBarValue::class.java)
        val progressBar = activity.view

        progressBar.numStars = 6
        assertThat(activity.numStarsValue, equalTo(6))

        activity.numStarsValue = 7
        assertThat(progressBar.numStars, equalTo(7))
    }

}