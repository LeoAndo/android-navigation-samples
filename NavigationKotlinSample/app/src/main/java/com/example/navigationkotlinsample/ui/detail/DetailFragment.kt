package com.example.navigationkotlinsample.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.navigationkotlinsample.Person
import com.example.navigationkotlinsample.R
import com.example.navigationkotlinsample.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
    private val navArgs by navArgs<DetailFragmentArgs>()
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        val person: Person = navArgs.person
        binding?.also {
            it.textName.text = "Name： " + person.name
            it.textAge.text = "Age： " + person.age
            it.textHeight.text = "Height： " + String.format("%.1f", person.height)
        }
    }
}