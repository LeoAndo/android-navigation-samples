package com.example.navigationjavasample.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationjavasample.Person;
import com.example.navigationjavasample.R;
import com.example.navigationjavasample.databinding.FragmentHomeBinding;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    public HomeFragment(){
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);
        final Person person = new Person("Tanaka", 20, 177.7F);
        binding.btnGoToDetail.setOnClickListener((v) -> {
            findNavController(HomeFragment.this).navigate(HomeFragmentDirections.actionNavigationHomeToDetailFragment(person));
        });
    }
}