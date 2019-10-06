package com.example.mybible.navigationDrawer;

import android.content.Intent;
import android.os.Bundle;

import com.example.mybible.R;
import com.example.mybible.SelectActivity;
import com.example.mybible.fragment.OldBibleFragment;
import com.example.mybible.fragment.SelectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

  BottomNavigationView.OnNavigationItemSelectedListener
          onNavigationItemSelectedListener
           =new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
          Fragment fragment =null;
            int id = menuItem.getItemId();

            if(id==R.id.bible){
                //Intent intent=new Intent(MenuActivity.this, SelectActivity.class);
                //startActivity(intent);
                //finish();
                fragment =new SelectFragment();

            }
            else if(id==R.id.tafseer){

            }
            else if(id==R.id.radio){

            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();


          return true;
      }
  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
          navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


    }

}
