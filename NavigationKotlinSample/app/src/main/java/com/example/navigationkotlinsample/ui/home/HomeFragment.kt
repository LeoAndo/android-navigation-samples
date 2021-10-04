package com.example.navigationkotlinsample.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.navigationkotlinsample.Person
import com.example.navigationkotlinsample.R
import com.example.navigationkotlinsample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val person = Person("Tanaka", 20, 177.7f)
        binding?.btnGoToDetail?.setOnClickListener {
            findNavController(this@HomeFragment).navigate(
                HomeFragmentDirections.actionNavigationHomeToDetailFragment(person)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}