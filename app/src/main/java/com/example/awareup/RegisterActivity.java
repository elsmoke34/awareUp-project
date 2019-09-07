package com.example.awareup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    public void click (View view)
    {
        Intent intentRegister = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intentRegister);
    }

    public void setData() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users");

        Map<String, Object> user = new HashMap<>();
        user.put("email", "email_hint");
        user.put("username", "username_hint");
        user.put("password", "password_hint");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
