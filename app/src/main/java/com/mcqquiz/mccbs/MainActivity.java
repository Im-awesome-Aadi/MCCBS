package com.mcqquiz.mccbs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.mcqquiz.mccbs.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ActivityMainBinding binding;
    static String dob="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.name.getText().toString().isEmpty())
                {
                    binding.name.setError("Enter your name!!");
                    return;
                }

                if(binding.dateOfBirth.getText().toString().isEmpty())
                {
                    binding.dateOfBirth.setError("Enter your date of birth!!");
                    return;
                }

                if(binding.mobile.getText().toString().isEmpty())
                {
                    binding.mobile.setError("Enter your mobile number!!");
                    return;
                }

                if(binding.mobile.getText().toString().length()<10)
                {
                    binding.mobile.setError("Enter valid mobile number in 10 digits!!");
                    return;
                }

                String email = binding.email.getText().toString().trim();

                if(email.isEmpty())
                {
                    binding.email.setError("Enter your email!!");
                    return;
                }

                boolean mail=validateEmailAddress(email);
                if(!mail)
                {
                    binding.email.setError("Enter valid email address !!");
                    return;
                }

                String password=binding.password.getText().toString().trim();

                boolean passwrd=validatePassword(password);

                if(!passwrd)
                {
                    binding.password.setError("Enter a strong password !!");
                    return;
                }

                if(binding.password.getText().toString().isEmpty() )
                {
                    binding.password.setError("Enter your password !!");
                    return;
                }


                if(binding.confirmPassword.getText().toString().isEmpty() )
                {
                    binding.confirmPassword.setError("Confirm your password !!");
                    return;
                }


                if(!binding.confirmPassword.getText().toString().equals(binding.password.getText().toString()))
                {
                    binding.confirmPassword.setError("Password and confirm password must be same!!");
                    return;
                }

                Intent i=new Intent(MainActivity.this, ActivityNext.class);
                i.putExtra("name",binding.name.getText().toString());
                i.putExtra("dob",binding.dateOfBirth.getText().toString());
                i.putExtra("mobile",binding.mobile.getText().toString());
                i.putExtra("email",binding.email.getText().toString());
                i.putExtra("password",binding.password.getText().toString());
                i.putExtra("confirmPassword",binding.confirmPassword.getText().toString());
                startActivity(i);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        dob=currentDateString;
        binding.dateOfBirth.setText(currentDateString);
    }

    private boolean validateEmailAddress(String emailAddress){
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    private boolean validatePassword(String password){
        String  expression="^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        CharSequence inputStr = password;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

}