package com.mcqquiz.mccbs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mcqquiz.mccbs.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}