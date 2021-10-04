package com.example.navigationjavasample;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationjavasample.databinding.FragmentSplashBinding;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class SplashFragment extends Fragment {
    private FragmentSplashBinding binding = null;

    public SplashFragment() {
        super(R.layout.fragment_splash);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSplashBinding.bind(view);
        binding.animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                findNavController(SplashFragment.this).navigate(
                        SplashFragmentDirections.actionSplashFragmentToLoginFragment()
                );
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}