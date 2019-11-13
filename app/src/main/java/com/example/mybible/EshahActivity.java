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

import static com.example.mybible.Contents.statment;

public class EshahActivity extends AppCompatActivity {
   EshahAdapter adapter;
   RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
   TextView titel,kind;
    int biblePosition;
    String bibleName;
    int bibleIndx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshah);
        recyclerView=findViewById(R.id.eshah_recycler_view);
        titel=findViewById(R.id.title);
        kind= findViewById(R.id.kind);
        adapter= new EshahAdapter(Contents.EshahName);
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        biblePosition = getIntent()
                .getIntExtra("pos", -1);
        bibleName = getIntent().getStringExtra("name");
        bibleIndx =getIntent().getIntExtra("indx",-5);
         cases();

        adapter.setOnclickLisetner(new EshahAdapter.OnclickLisetner() {

            @Override
            public void onItemClick(int Epos, String name) {



               Intent i = new Intent(EshahActivity.this,VersesShowActivity.class);
             //   Toast.makeText(EshahActivity.this,biblePosition+"newdkjnfekjfn", Toast.LENGTH_SHORT).show();


               i.putExtra("Eshahpos",Epos);
               i.putExtra("biblePostion",biblePosition);
               i.putExtra("indx",bibleIndx);

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


    public void cases(){
        if(Contents.state==2){kind.setText("تفســـير");}
        else{
            kind.setText("قراءة") ;
        }
        if (statment == "old_statment" ) {
            //Toast.makeText(this, "inner if", Toast.LENGTH_SHORT).show();

            titel.setText("ســـفـر"+bibleName);
        }
        else if(statment == "new_statment" && biblePosition<=3){
            titel.setText("انجـيـل"+"  "+bibleName);
        }
        else if(statment == "new_statment" && biblePosition==4){
            titel.setText("سفر"+"  "+bibleName);
        }
        else if(statment == "new_statment" && biblePosition>4 &&biblePosition<=25){
            titel.setText("رســـالة"+" "+bibleName);
        }
        else{ titel.setText(bibleName);}


    }
}
