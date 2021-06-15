package com.mcqquiz.mccbs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mcqquiz.mccbs.databinding.ActivityNextBinding;

public class ActivityNext extends AppCompatActivity {

    ActivityNextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String name = getIntent().getStringExtra("name");
        String dob = getIntent().getStringExtra("dob");
        String mobile = getIntent().getStringExtra("mobile");

        String email= getIntent().getStringExtra("email");
        String password= getIntent().getStringExtra("password");
        String confirmPassword= getIntent().getStringExtra("confirmPassword");

        binding.name.setText(name);
        binding.dob.setText(dob);
        binding.mobile.setText(mobile);

        binding.email.setText(email);
        binding.password.setText(password);
        binding.confirmPassword.setText(confirmPassword);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityNext.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}