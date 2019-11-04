package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EshahActivity extends AppCompatActivity {
   EshahAdapter adapter;
   RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
   TextView titel;
    int biblePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshah);
        recyclerView=findViewById(R.id.eshah_recycler_view);

        adapter= new EshahAdapter(Contents.EshahName);
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        biblePosition = getIntent()
                .getIntExtra("pos", -1);

        adapter.setOnclickLisetner(new EshahAdapter.OnclickLisetner() {

            @Override
            public void onItemClick(int Epos, String name) {



               Intent i = new Intent(EshahActivity.this,VersesShowActivity.class);
             //   Toast.makeText(EshahActivity.this,biblePosition+"newdkjnfekjfn", Toast.LENGTH_SHORT).show();


               i.putExtra("Eshahpos",Epos);
               i.putExtra("biblePostion",biblePosition);

              // i.putExtra("name",-3);
               startActivity(i);
                adapter= new EshahAdapter(Contents.EshahName);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.updateData();
    }


    /** @Override
    protected void onStart() {
        super.onStart();
        adapter.updateData();
    }  */
}
