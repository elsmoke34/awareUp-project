package com.example.awareup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btnregister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                createNewAccount();
            }
        });

    }

    private EditText txtEmail, txtUsername, txtPassword;
    private Button btnregister;

    private FirebaseAuth auth;

  public void init(){

        auth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.email_hint);
        txtUsername = findViewById(R.id.username_hint);
        txtPassword = findViewById(R.id.password_hint);
        btnregister = findViewById(R.id.btn_create);


  }

    private void createNewAccount()
    {
        String username = txtUsername.getText().toString();
        String email = txtEmail.getText().toString();
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
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this, "Hesabınız başarılı bir şekilde oluşturuldu!", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, MainPageActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else
                        {
                        Toast.makeText(RegisterActivity.this, "Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
