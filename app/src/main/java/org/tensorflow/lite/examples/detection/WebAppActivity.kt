package org.tensorflow.lite.examples.detection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.tensorflow.lite.examples.detection.R

class WebAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_app)
    }
}