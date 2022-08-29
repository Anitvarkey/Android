package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.implicitintent.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        Button maps, messenger, gmail, playstore;
        Intent i, chooser = null ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            maps = (Button) findViewById(R.id.maps);
            messenger = (Button) findViewById(R.id.messenger);
            gmail = (Button) findViewById(R.id.gmail);
            playstore = (Button) findViewById(R.id.playstore);

            maps.setOnClickListener(this);
            messenger.setOnClickListener(this);
            gmail.setOnClickListener(this);
            playstore.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.maps) {
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo: 10.065206, 76.629128"));
                chooser = i.createChooser(i, "Maps");
                startActivity(chooser);
            } else if(v.getId() == R.id.messenger) {
                i = new Intent(Intent.ACTION_SEND);
                Uri imageUri = Uri.parse("android.resource://implictintent/drawable/" + R.drawable.hi);
                i.setType("image/*");
                i.putExtra(i.EXTRA_STREAM, imageUri);
                i.putExtra(i.EXTRA_TEXT, "image");
                chooser = i.createChooser(i, "Messenger");
                startActivity(chooser);
            } else if (v.getId() == R.id.playstore) {
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.zhiliaoapp.musically&hl=en_US&gl=US"));
                chooser = i.createChooser(i, "Playstore");
                startActivity(chooser);
            } else {
                i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto"));
                String to[] = {"mymail@gmail.com"};
                i.putExtra(i.EXTRA_EMAIL, to);
                i.putExtra(i.EXTRA_SUBJECT, "From mymail");
                i.putExtra(i.EXTRA_TEXT, "My mail");
                i.setType("message/rfc822");
                chooser = i.createChooser(i, "Email");
                startActivity(chooser);
            }
        }
    }
