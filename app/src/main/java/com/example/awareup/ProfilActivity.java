package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        ImageView profil_btn = findViewById(R.id.profil_btn);
        profil_btn.setEnabled(false);

    }

    public void clickToMainFromProfil (View view)
    {
        Intent intentMainPage = new Intent(ProfilActivity.this, MainPageActivity.class);
        startActivity(intentMainPage);
    }

    public void clickToAddingFromProfil (View view)
    {
        Intent intentAdding = new Intent(ProfilActivity.this, AddingActivity.class);
        startActivity(intentAdding);
    }


}
