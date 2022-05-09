package com.assignment.marktalentgreenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        tvCreateAccount = findViewById(R.id.tv_button);

        tvCreateAccount.setOnClickListener(view -> {

            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ActivityCreateAccount.class);
            startActivity(intent);
        });



    }




}