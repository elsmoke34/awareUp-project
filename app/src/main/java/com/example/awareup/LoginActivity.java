package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {



    public void click (View view)
    {
        Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentLogin);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
