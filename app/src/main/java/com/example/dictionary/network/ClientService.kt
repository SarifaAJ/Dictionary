package com.example.dictionary.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ClientService {
    fun create(file: Boolean): ApiServiceServer {
        var cTO:Long = 30
        var wTO:Long = 30
        var rTO:Long = 30

        if (file){
            cTO = 120
            wTO = 120
            rTO = 120
        }

        val interceptor = HttpLoggingInterceptor(Logger())
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        //val interceptorAccept = Interceptor { chain ->
        //    val newRequest: Request = chain.request().newBuilder()
        //        .addHeader("Accept", "application/json")
        //        .build()
        //    chain.proceed(newRequest)
        //}
        //
        //val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        //    .addInterceptor(interceptorAccept)
        //    .addInterceptor(interceptor) //interceptor hanya untuk debug link tidak untuk release
        //    .connectTimeout(cTO, TimeUnit.SECONDS)
        //    .writeTimeout(wTO, TimeUnit.SECONDS)
        //    .readTimeout(rTO, TimeUnit.SECONDS)
        //    .build()

        val okHttpClient =  OkHttpClient.Builder()
        okHttpClient.connectTimeout(cTO, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(wTO, TimeUnit.SECONDS)
        okHttpClient.readTimeout(rTO, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(HttpLoggingInterceptor(Logger()).apply { level = HttpLoggingInterceptor.Level.BODY })

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("http://jepang.aws.web.id/apis/")
            .client(okHttpClient.build())
            .build()

        return retrofit.create(ApiServiceServer::class.java)
    }
}
