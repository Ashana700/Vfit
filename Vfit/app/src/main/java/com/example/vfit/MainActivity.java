package com.example.vfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,new Connect()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener (){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.connect:
                            selectedFragment= new Connect();
                            break;
                        case R.id.exercise:
                            selectedFragment= new Exercise();
                            break;
                        case R.id.feed:
                            selectedFragment= new Feed();
                            break;
                        case R.id.profile:
                            selectedFragment= new Profile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,selectedFragment).commit();
                    return true;
                }
            };
}