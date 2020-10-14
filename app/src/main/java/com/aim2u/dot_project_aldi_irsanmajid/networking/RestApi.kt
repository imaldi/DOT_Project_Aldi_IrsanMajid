package com.aim2u.dot_project_aldi_irsanmajid.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestApi {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl("https://dot-android-internship-test.web.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
        fun service() : ApiService = getRetrofit().create(ApiService::class.java)
}