package org.tensorflow.lite.examples.detection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.detection.databinding.ActivityUploadBinding
import org.tensorflow.lite.examples.detection.databinding.ActivityWebAppBinding

class UploadActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityUploadBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.uploadButton.setOnClickListener { uploadVideo() }
    }


    private fun uploadVideo() {
        // TODO
        Log.i(TAG, intent.data!!.lastPathSegment!!)
    }

    companion object {
        private const val TAG = "UploadActivity"
    }
}