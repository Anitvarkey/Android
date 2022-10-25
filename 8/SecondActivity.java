package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    EditText username, password;
    Button bttn_login, bttn_prev;
    Toast t;

    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp = getSharedPreferences("Mypref", MODE_PRIVATE);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        bttn_login = (Button) findViewById(R.id.bttn_login);
        bttn_prev = (Button) findViewById(R.id.bttn_prev);

        bttn_login.setOnClickListener(this);
        bttn_prev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bttn_prev)
            startActivity(new Intent(this, MainActivity.class));
        if(v.getId() == R.id.bttn_login) {
            a = username.getText().toString();
            b = password.getText().toString();
            Toast t1;

            if (a.equals(sp.getString("Username", "")) && b.equals(sp.getString("Password", ""))) {
                t1 = Toast.makeText(this, "Login successful", Toast.LENGTH_LONG);
                t1.setGravity(Gravity.TOP, 0, 200);
                LayoutInflater lin = getLayoutInflater();
                View appear = lin.inflate(R.layout.mytoast, (ViewGroup) findViewById(R.id.toast_id));
                t1.setView(appear);
                t1.show();
            } else
                Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_LONG).show();
        }
    }
}
