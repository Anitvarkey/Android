package com.example.markcalculate;

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

import com.example.markcalculate.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


        EditText name,physics,maths,chemistry;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


        }

        public void calculateMarks(View view) {
            int physics_mark,chemistry_mark,maths_mark,percentage;
            String full_name,message;

            name = (EditText) findViewById(R.id.full_name);

            full_name = name.getText().toString();

            physics = (EditText) findViewById(R.id.physics_mark);
            maths = (EditText) findViewById(R.id.maths_mark);
            chemistry = (EditText) findViewById(R.id.chemistry_mark);

            physics_mark = Integer.parseInt(physics.getText().toString());
            chemistry_mark = Integer.parseInt(chemistry.getText().toString());
            maths_mark = Integer.parseInt(maths.getText().toString());

            percentage = ( physics_mark + chemistry_mark + maths_mark ) / 3;
            message = (percentage >= 50) ? "Congrats " + full_name + " , You have passed" : "Better Luck next time";

            SharedPreferences sp = getSharedPreferences("MarkDetails",MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putInt("percentage",percentage);
            editor.putString("message",message);
            editor.commit();

            startActivity(new Intent(this,SecondActivity.class));

        }
    }
