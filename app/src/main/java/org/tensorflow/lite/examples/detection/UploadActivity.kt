package org.tensorflow.lite.examples.detection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType
import okhttp3.RequestBody
import org.tensorflow.lite.examples.detection.databinding.ActivityUploadBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


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

        val requestBody = RequestBody.create(
            MediaType.parse("video/mp4"),
            File(applicationContext.filesDir, "video.mp4")
        );

        val serverCall = serverApi.uploadVideo(requestBody)

        serverCall!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    companion object {
        private const val TAG = "UploadActivity"
    }
}