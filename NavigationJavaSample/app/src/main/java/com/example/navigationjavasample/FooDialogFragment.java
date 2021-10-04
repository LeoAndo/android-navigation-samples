package com.example.navigationjavasample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.navigationjavasample.databinding.DialogFooBinding;

public class FooDialogFragment extends AppBottomSheetDialogFragment {
    private DialogFooBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogFooBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
