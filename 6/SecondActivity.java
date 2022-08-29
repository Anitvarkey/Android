package com.example.markcalculate;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.markcalculate.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView percent,msg;


        percent = (TextView) findViewById(R.id.percentage);
        msg = (TextView) findViewById(R.id.message);


        SharedPreferences sp = getSharedPreferences("MarkDetails",MODE_PRIVATE);
        int percentage = sp.getInt("percentage",0);
        String message = sp.getString("message","Message");

        String percent_string =  percentage + "%";

        percent.setText(percent_string);
        msg.setText(message);

        if (percentage < 50)
            msg.setTextColor(getResources().getColor(R.color.purple_200));
    }
}
