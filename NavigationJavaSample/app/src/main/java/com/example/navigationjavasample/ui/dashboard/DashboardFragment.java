package com.example.navigationjavasample.ui.dashboard;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationjavasample.R;
import com.example.navigationjavasample.databinding.FragmentDashboardBinding;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;

    public DashboardFragment() {
        super(R.layout.fragment_dashboard);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.bind(view);
        binding.button.setOnClickListener((v) -> {
            findNavController(DashboardFragment.this).navigate(
                    DashboardFragmentDirections.actionNavigationDashboardToFooDialogFragment()
            );
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}