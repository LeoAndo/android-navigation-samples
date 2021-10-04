package com.example.navigationjavasample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigationjavasample.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        initNavController();
        observeDestination();
    }
    private void observeDestination() {
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> updateContent(destination.getId()));
    }

    private void initNavController() {
        NavHostFragment host  = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = Objects.requireNonNull(host).getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        binding.navView.inflateMenu(R.menu.bottom_nav_menu);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @SuppressLint("NonConstantResourceId")
    private void updateContent (int destinationId) {
        switch (destinationId) {
            case R.id.splashFragment :
            case R.id.loginFragment :
                Objects.requireNonNull(getSupportActionBar()).hide();
                binding.navView.setVisibility(View.GONE);
                break;
            default:
                Objects.requireNonNull(getSupportActionBar()).show();
                binding.navView.setVisibility(View.VISIBLE);
                break;
        }
    }
}