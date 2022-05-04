package org.tensorflow.lite.examples.detection


import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


data class ServerResponse(val message: String)

interface ServerApi {
    @Multipart
    @POST("api/video_upload")
    @Headers("Accept:application/json")
    fun uploadVideo(
        @Part file: MultipartBody.Part
    ): Call<ServerResponse?>?


    @GET("api/get_count")
    @Headers("Accept:application/json")
    fun getCount(@Query("crop") crop: String): Call<ServerResponse?>?

    companion object {
        private const val BASE_URL =
            "http://192.168.18.6:3000/" // TODO Change according to server location

        fun create(): ServerApi {

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.MINUTES)
                .writeTimeout(60, TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ServerApi::class.java)
        }
    }


}