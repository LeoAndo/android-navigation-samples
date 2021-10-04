package com.example.navigationjavasample.ui.notifications;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationjavasample.R;
import com.example.navigationjavasample.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;
    public NotificationsFragment(){
        super(R.layout.fragment_notifications);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentNotificationsBinding.bind(view);
        binding.button4.setOnClickListener((v)-> {
            Log.d("AAA", "clicke!!!");
            binding.progressIndicatorLayout.show();
            new Handler(Looper.myLooper()).postDelayed(()->{
                binding.progressIndicatorLayout.hide();
            }, 3000);
        });
    }
}