package com.example.intentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.intentapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    TextView name,email;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        name = (TextView) findViewById(R.id.uname);
        email = (TextView) findViewById(R.id.mail);

        if(sp.contains("Name"))
            name.setText(sp.getString("Name",""));
        if(sp.contains("Email"))
            email.setText(sp.getString("Email", ""));
    }
    public void Previous(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
