package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        ImageView btn_home = (ImageView) findViewById(R.id.home_btn);
        btn_home.setEnabled(false);

    }


    public void btn_notification(View view)
    {
        Intent intentNotification = new Intent(MainPageActivity.this, NotificationActivity.class);
        startActivity(intentNotification);
    }

    public void btn_profil(View view)
    {
        Intent intentProfil = new Intent(MainPageActivity.this, ProfilActivity.class);
        startActivity(intentProfil);
    }



















}
