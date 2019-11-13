package com.example.mybible;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybible.adapters.BibleAdapter;
import com.example.mybible.adapters.VersesAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.mybible.Contents.EshahIndex;
import static com.example.mybible.Contents.EshahName;
import static com.example.mybible.Contents.OldEshahIndex;

public class VersesShowActivity extends AppCompatActivity {
VersesAdapter adapter;
  RecyclerView recyclerView;
  RecyclerView.LayoutManager layoutManager;
   View view;
    int bibleIndx;
   int BiBlePosition;
   int EshahPostion;

    ArrayList<String> verses;
  //  ArrayList<String> vrr;
     TextView title;
     Button previouse ,next,tafseer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses_show);
        recyclerView=findViewById(R.id.verses_recycler_view);
        title =findViewById(R.id.eshah_name);
         previouse=findViewById(R.id.back);
         next = findViewById(R.id.next);
         tafseer=findViewById(R.id.tafseer);
      //  adapter=new VersesAdapter(null);


        BiBlePosition = getIntent()
                .getIntExtra("biblePostion", -7);
        EshahPostion = getIntent()
                .getIntExtra("Eshahpos", -2);
        bibleIndx=getIntent().getIntExtra("indx",-4);
        EshahPostion =  EshahPostion + 1 ;

          if(Contents.state == 2){
              readingTafseer();
          }

       else{ reading();}





      //  SnapHelper helper=new PagerSnapHelper();
        //helper.attachToRecyclerView(recyclerView);

    }



    public ArrayList<String> readEshahFromFile(String fileName) {
        ArrayList<String> allVerses = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                allVerses.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return allVerses;
    }
    public ArrayList<String> readtafseerFromFile(String fileName) {
        ArrayList<String> tafseer = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("filename.txt")));
        }
        catch (IOException e) {}

        return tafseer;
    }
        public void previuos(){
            if(EshahPostion == 1)return;
        EshahPostion =EshahPostion -1;
        if(Contents.cases == 1){
            reading();
        }
        else{
            readingTafseer();
        }


        }
    public void nextOne(){
        if( EshahPostion== bibleIndx)return;
        EshahPostion =EshahPostion +1;
        if(Contents.cases == 1){
            reading();
        }
        else{
            readingTafseer();
        }


    }

        public void reading(){
        Contents.cases =1;
        verses= readEshahFromFile(Contents.statment+"/"+BiBlePosition+"/"+EshahPostion+".txt");
            title.setText("اصحاح"+EshahPostion);
            tafseer.setText("التفسير");
            tafseer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    readingTafseer();
                }
            });

               previouse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    previuos();
                }
            });
               next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextOne();
                }

            });
            layoutManager = new LinearLayoutManager(VersesShowActivity.this);
            adapter = new VersesAdapter(verses);

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
      public void readingTafseer(){
              Contents.cases =2;
              String mofaser = Contents.mofaserName;
        //  Toast.makeText(this, ""+Contents.statment, Toast.LENGTH_SHORT).show();
          verses= readEshahFromFile("tafseer"+"/"+mofaser+"/"+Contents.statment+"/"+BiBlePosition+"/"+EshahPostion+".txt");
            tafseer.setText("قراءة الاصحاح");
            title.setText(  "تفسير أصحاح رقم" +" "+ EshahPostion);
          tafseer.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  reading();
              }
          });
          previouse.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  previuos();
              }
          });
          next.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  nextOne();
              }

          });



          layoutManager = new LinearLayoutManager(VersesShowActivity.this);
          adapter = new VersesAdapter(verses);

          recyclerView.setLayoutManager(layoutManager);

          recyclerView.setLayoutManager(layoutManager);
          recyclerView.setAdapter(adapter);
      }


}
