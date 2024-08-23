package com.example.finance;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class customer extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    homeFragment homefragment = new homeFragment();
    profileFragment profilefragment = new profileFragment();
    logoutFragment logoutfragment = new logoutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homefragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
                return true;
            } else if (itemId == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profilefragment).commit();
                return true;
            } else if (itemId == R.id.logout) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, logoutfragment).commit();


                return true;
            }
            return true;
        });

    }
}