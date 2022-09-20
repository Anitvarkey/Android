package com.example.tcalculator7;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tcalculator7.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    TextView t1;
    double n1, n2;
    public boolean getNumbers() {


        e1 = (EditText) findViewById(R.id.n1);
        e2 = (EditText) findViewById(R.id.n2);
        t1 = (TextView) findViewById(R.id.t1);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        n1 = Double.parseDouble(s1);
        n2 =Double.parseDouble(s2);
        return true;
    }
    public void sum(View view) {
        if (getNumbers()) {
            Double sum = n1 + n2;
            t1.setText(Double.toString(sum));
        }
    }

    public void subt(View view) {
        if (getNumbers()) {
            Double sub = n1 - n2;
            t1.setText(Double.toString(sub));
        }
    }

    public void mult(View view) {
        if (getNumbers()) {
            Double m = n1  * n2;
            t1.setText(Double.toString(m));
        }
    }

    public void div(View view) {
        if (getNumbers()) {
            double d = n1 / n2;
            t1.setText(Double.toString(d));
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.n1);
        // defining the edit text 2 to e2
    }

    public void clear(View view) {
        t1.setText("");
        e1.setText("");
        e2.setText("");


    }
}
