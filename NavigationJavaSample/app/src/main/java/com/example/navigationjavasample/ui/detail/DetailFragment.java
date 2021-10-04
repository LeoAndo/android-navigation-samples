package com.example.navigationjavasample.ui.detail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationjavasample.Person;
import com.example.navigationjavasample.R;
import com.example.navigationjavasample.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    public DetailFragment() {
        super(R.layout.fragment_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDetailBinding.bind(view);
        final Person person = DetailFragmentArgs.fromBundle(requireArguments()).getPerson();
        binding.textName.setText("名前： "+ person.getName());
        binding.textAge.setText("年齢： " + person.getAge());
        binding.textHeight.setText("身長： " +  String.format("%.1f", person.getHeight()));
    }
}