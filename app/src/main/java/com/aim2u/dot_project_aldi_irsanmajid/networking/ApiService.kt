package com.aim2u.dot_project_aldi_irsanmajid.networking

import com.aim2u.dot_project_aldi_irsanmajid.model.ResponsePlace
import com.aim2u.dot_project_aldi_irsanmajid.model.ResponseProfile
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("user.json")
    fun getProfile(): Single<ResponseProfile>


}