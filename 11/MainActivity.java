package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.registrationform.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    EditText email, password;
    Button login, signup;

    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("Mypref", MODE_PRIVATE);
        email = (EditText) findViewById(R.id.em);
        password = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signup)
            startActivity(new Intent(this, SecondActivity.class));
        if (v.getId() == R.id.login) {
            a = email.getText().toString();
            b = password.getText().toString();
            Toast t1;

            if (a.equals(sp.getString("Username", "")) && b.equals(sp.getString("Password", ""))) {
                t1 = Toast.makeText(this, "Login successful", Toast.LENGTH_LONG);
                t1.show();
            } else
                Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_LONG).show();
        }
    }
}
