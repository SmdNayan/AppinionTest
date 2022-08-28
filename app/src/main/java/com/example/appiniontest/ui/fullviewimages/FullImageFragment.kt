package com.example.appiniontest.ui.fullviewimages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.appiniontest.R
import com.example.appiniontest.databinding.FragmentFullImageBinding

class FullImageFragment : Fragment() {
    private lateinit var binding: FragmentFullImageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_full_image, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("SMD", "onViewCreated: " +  arguments?.getString("image_url"))

        binding.imageUrl = arguments?.getString("image_url")

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}