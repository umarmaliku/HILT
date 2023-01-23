package com.example.hilt.ui.fragments.getphotofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.hilt.data.adapters.CharacterAdapter
import com.example.hilt.databinding.FragmentGetPhotoBinding
import com.example.hilt.ui.fragments.postphotofragment.PhotosViewModel

class GetPhotoFragment : Fragment() {

    private var binding: FragmentGetPhotoBinding? = null
    private val viewModel by viewModels<GetViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetPhotoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserves()
    }

    private fun setUpObserves() {
        viewModel.photoLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}