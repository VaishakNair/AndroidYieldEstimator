package org.tensorflow.lite.examples.detection

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part


data class ServerResponse(val message: String)

interface ServerApi {
    @Multipart
    @PUT("api/video_upload")
    fun uploadVideo(
        @Part("file") file: RequestBody?
    ): Call<ServerResponse?>?

    companion object {
        private const val BASE_URL = "http://localhost:3000" // TODO Change according to server location

        fun create(): ServerApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ServerApi::class.java)
        }
    }


}