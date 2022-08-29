package com.example.linearlayoutcode;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.linearlayoutcode.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        LinearLayout lin;
        TextView t;
        Button b;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lin = new LinearLayout(this);
            t = new TextView(this);
            b = new Button(this);

            LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
            lin.setLayoutParams(dim);

            LinearLayout.LayoutParams vdim = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            vdim.setMargins(0, 50, 0, 0);
            t.setLayoutParams(vdim);
            b.setLayoutParams(vdim);

            lin.setOrientation(LinearLayout.VERTICAL);
            lin.setVerticalGravity(Gravity.CENTER);

            t.setText("Hello Guys");
            t.setGravity(Gravity.CENTER);
            t.setTextSize(35);
            t.setTextColor(Color.RED);
            t.setTypeface(Typeface.DEFAULT_BOLD);
            b.setText("WELCOME");
            b.setBackgroundColor(Color.CYAN);

            lin.addView(t);
            lin.addView(b);
            setContentView(lin);
        }
    }
