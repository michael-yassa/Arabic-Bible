package com.example.mybible.navigationDrawer;

import android.content.Intent;
import android.os.Bundle;

import com.example.mybible.R;
import com.example.mybible.SelectActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bible:
                    Intent intent=new Intent(MenuActivity.this, SelectActivity.class);
                    startActivity(intent);
                    finish();
                case R.id.tafseer:
                    mTextMessage.setText(R.string.tafseer);
                    return true;
                case R.id.radio:
                    mTextMessage.setText(R.string.radio);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
