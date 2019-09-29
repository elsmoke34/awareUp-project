package com.example.awareup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_activity);

        ImageView btn_home = (ImageView) findViewById(R.id.home_btn);
        btn_home.setEnabled(false);
        init();
    }

    private FirebaseUser currentUser;

    public void init()
    {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
    }



    public void clickToProfil(View view)
    {
        Intent intentProfil = new Intent(MainPageActivity.this, ProfilActivity.class);
        startActivity(intentProfil);
    }

    public void clickToAddingFromMain(View view)
    {
        Intent intentAddingMain = new Intent(MainPageActivity.this, AddingActivity.class);
        startActivity(intentAddingMain);
    }


    /*public void clickToNotification (View view)
    {
        Intent intentNotification = new Intent(MainPageActivity.this, NotificationActivity.class);
        startActivity(intentNotification);
    }*/





    public void onStart()
    {
        if(currentUser==null)
        {
            Intent girisIntent = new Intent(MainPageActivity.this, MainActivity.class);
            startActivity(girisIntent);
            finish();
        }
        super.onStart();
    }



















}
