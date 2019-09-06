package com.example.awareup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    public void click (View view)
    {
        Intent intentLogin = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intentLogin);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
