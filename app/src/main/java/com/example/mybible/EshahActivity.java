package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class EshahActivity extends AppCompatActivity {
   EshahAdapter adapter;
   RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshah);
        recyclerView=findViewById(R.id.eshah_recycler_view);
        adapter= new EshahAdapter(Contents.EshahName);
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.EshahName.clear();
      //  recyclerView=null;
    }



    @Override
    protected void onResume() {
        super.onResume();
        recyclerView=null;
    }
}
