package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {
  Button newBible,oldBible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        newBible=findViewById(R.id.new_bible);
        oldBible=findViewById(R.id.oldbible);
        oldBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this, OldBibleActivity.class);
                startActivity(intent);
            }
        });
        newBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this,NewBibleActivity.class);
                startActivity(intent);
            }
        });
    }
}
