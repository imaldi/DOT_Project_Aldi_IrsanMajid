package com.aim2u.dot_project_aldi_irsanmajid.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aim2u.dot_project_aldi_irsanmajid.model.ResponseProfile
import com.aim2u.dot_project_aldi_irsanmajid.repository.Repository

class ProfileViewModel : ViewModel() {

    private var repository = Repository()

    var responseProfile = MutableLiveData<ResponseProfile>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()


//    private val _text = MutableLiveData<String>().apply {
//        value = "This is notifications Fragment"
//    }
//    val text: LiveData<String> = _text


    fun getProfile(){
        isLoading.value = true
        repository.getProfile({
            responseProfile.value = it
            isLoading.value = false
        },{
            isError.value = it
            isLoading.value = false
        })
    }
}
