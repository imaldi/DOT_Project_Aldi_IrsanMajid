package com.aim2u.dot_project_aldi_irsanmajid.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.aim2u.dot_project_aldi_irsanmajid.R
import com.aim2u.dot_project_aldi_irsanmajid.model.ProfileData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        profileViewModel.getProfile()
        attachObserver()

        val root = inflater.inflate(R.layout.fragment_profile, container, false)
//        profileViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
//        })

        return root
    }

    private fun attachObserver(){
        profileViewModel.responseProfile.observe(viewLifecycleOwner, { showData(it.profileData) })
        profileViewModel.isLoading.observe(viewLifecycleOwner, { connectionToast(it) })
        profileViewModel.isError.observe(viewLifecycleOwner,{ showError(it.message)})
    }

    private fun showError(message: String?) {
        Toast.makeText(requireContext(), "An Error Occured : "+message, Toast.LENGTH_SHORT).show()
    }

    private fun connectionToast(it: Boolean?) {
//        if(it == true)
//            Toast.makeText(requireContext(), "Need Internet Connection", Toast.LENGTH_SHORT).show()
    }

    private fun showData(
//        message : String?
        profileData: ProfileData?
    ) {
//        Toast.makeText(requireContext(), ""+ message, Toast.LENGTH_SHORT).show()
        txt_username.text = profileData?.username
        txt_full_name.text = profileData?.fullname
        txt_email.text = profileData?.email
        txt_phone.text = profileData?.phone

        Glide.with(requireContext()).load(profileData?.avatar).into(img_profile)
    }
}