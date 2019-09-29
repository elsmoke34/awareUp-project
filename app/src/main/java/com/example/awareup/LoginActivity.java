package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText txtMail, txtPassword;
    private Button btn_login;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }

    public void init()
    {
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        txtMail = findViewById(R.id.username_hint_login);
        txtPassword = findViewById(R.id.password_hint_login);
        btn_login = findViewById(R.id.btn_login);


    }


    public void click (View view)
    {
        Intent intentLogin = new Intent(LoginActivity.this, MainPageActivity.class);
        startActivity(intentLogin);
    }

    public void loginUser()
    {
        String email = txtMail.getText().toString();
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Email Alanı Boş Olamaz!", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Şifre Alanı Boş Olamaz!", Toast.LENGTH_SHORT).show();
        }

        else {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Başarılı Giriş!", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(LoginActivity.this, MainPageActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}





