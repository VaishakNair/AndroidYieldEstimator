package org.tensorflow.lite.examples.detection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType
import okhttp3.MultipartBody
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


        val videoFile = File(applicationContext.filesDir, "video.mp4")
        Log.i(TAG, videoFile.exists().toString())

        val requestBody = RequestBody.create(
            MediaType.parse("video/mp4"),
            videoFile
        );

        val body = MultipartBody.Part.createFormData("file", videoFile.name, requestBody)

        val serverCall = serverApi.uploadVideo(body)

        serverCall!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                // TODO
                if(response.isSuccessful) {
                    getCount()
                }
                Log.i(TAG, response.isSuccessful.toString())
                Log.i(TAG, response.message())
                Log.i(TAG, response.code().toString())
                Log.i(TAG, response.body()!!.message)
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
               // TODO
                Log.i(TAG, "onFailure() Message: ${t.message}")

            }
        })

    }

    private fun getCount() {
        val serverCall = serverApi.getCount("tomato")

        serverCall!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                // TODO
                if(response.isSuccessful) {
                   Log.i(TAG, "Fruit count: ${response.body()!!.message}")
                }

            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                // TODO
                Log.i(TAG, "onFailure() Message: ${t.message}")
            }
        })

    }

    companion object {
        private const val TAG = "UploadActivity"
    }
}