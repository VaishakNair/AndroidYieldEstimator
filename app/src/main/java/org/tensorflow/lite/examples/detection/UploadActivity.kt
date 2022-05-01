package org.tensorflow.lite.examples.detection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.detection.databinding.ActivityUploadBinding


class UploadActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityUploadBinding

    private val serverApi = ServerApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.uploadButton.setOnClickListener { uploadVideo() }
    }


    private fun uploadVideo() {
        // TODO
        Log.i(TAG, intent.data!!.lastPathSegment!!)

        serverApi.uploadVideo().enqueue{

        }

    }

    companion object {
        private const val TAG = "UploadActivity"
    }
}