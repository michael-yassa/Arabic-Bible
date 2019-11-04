package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybible.fragment.NewBibleFragment;
import com.example.mybible.fragment.OldBibleFragment;

public class SelectActivity extends AppCompatActivity {
  Button newBible,oldBible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        newBible=findViewById(R.id.new_bible);
        oldBible=findViewById(R.id.oldbible);
        final Fragment fragment = null;

        oldBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  fragment[0] =new OldBibleFragment();
              //  Intent intent=new Intent(SelectActivity.this,OldBibleActivity.class );
                //startActivity(intent);
             //   fragment=new OldBibleFragment();
            }
        });
        newBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SelectActivity.this, NewBibleActivity.class);
                startActivity(intent);
            }
        });
    }
}
