package com.lacerdagroup.status;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.internal.EdgeToEdgeUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.internal.EdgeToEdgeUtils;
import com.lacerdagroup.status.databinding.ActivityMainBinding;
import com.lacerdagroup.status.ui.onboarding.OnboardingActivity;


public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    
    if (isFirstTimeUser()) {
      startOnboarding();
    }
    
    EdgeToEdgeUtils.applyEdgeToEdge(getWindow(), true);
    super.onCreate(savedInstanceState);
    
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(
                R.id.navigation_leira, R.id.navigation_home, R.id.navigation_horta)
            .build();
    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(binding.navView, navController);
  }
  
  
  
  private boolean isFirstTimeUser() {
    SharedPreferences preferences = getSharedPreferences("SetupPreferences", Context.MODE_PRIVATE);
    boolean isFirstTime = preferences.getBoolean("firstTime", true);

    if (isFirstTime) {
      SharedPreferences.Editor editor = preferences.edit();
      editor.putBoolean("firstTime", false);
      editor.apply();
    }

    return isFirstTime;
  }
  
  private void startOnboarding() {
    Intent intent = new Intent(this, OnboardingActivity.class);
    startActivity(intent);
  }
}
