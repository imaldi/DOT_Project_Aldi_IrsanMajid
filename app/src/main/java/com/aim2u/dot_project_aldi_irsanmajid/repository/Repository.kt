package com.aim2u.dot_project_aldi_irsanmajid.repository

import com.aim2u.dot_project_aldi_irsanmajid.model.ResponseProfile
import com.aim2u.dot_project_aldi_irsanmajid.networking.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {
    fun getProfile(responseHandler : (ResponseProfile) -> Unit, errorHandler : (Throwable) -> Unit){
        RestApi.service().getProfile().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}