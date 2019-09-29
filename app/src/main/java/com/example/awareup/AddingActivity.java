package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddingActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }


    public void clickToMainFromAdding (View view)
    {
        Intent intentMainPage;
        intentMainPage = new Intent(AddingActivity.this, MainPageActivity.class);
        startActivity(intentMainPage);
    }

    public void clickToProfilFromAdding (View view)
    {
        Intent intentProfil = new Intent(AddingActivity.this,ProfilActivity.class);
        startActivity(intentProfil);
    }


}
