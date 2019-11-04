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

   int BiBlePosition;
   int EshahPostion;
    ArrayList<String> verses;
    ArrayList<String> vs;
     TextView title;
     Button back;






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses_show);
        recyclerView=findViewById(R.id.verses_recycler_view);
        title =findViewById(R.id.eshah_name);
         back= findViewById(R.id.back);
      //  adapter=new VersesAdapter(null);


        BiBlePosition = getIntent()
                .getIntExtra("biblePostion", -7);
        EshahPostion = getIntent()
                .getIntExtra("Eshahpos", -2);
        EshahPostion =  EshahPostion + 1 ;
        verses= readEshahFromFile(Contents.statment+"/"+BiBlePosition+"/"+EshahPostion+".txt");
      // Toast.makeText(this, Contents.statment +BiBlePosition+"" , Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, Contents.statment+BiBlePosition+EshahPostion+"", Toast.LENGTH_SHORT).show();
      //  vs= readEshahFromFile("new_statment"+"/"+0+"/"+10+".txt");

      title.setText("اصحاح"+EshahPostion);


        layoutManager = new LinearLayoutManager(VersesShowActivity.this);
        adapter = new VersesAdapter(verses);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
      //  SnapHelper helper=new PagerSnapHelper();
        //helper.attachToRecyclerView(recyclerView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VersesShowActivity.this,SelectActivity.class);
                startActivity(intent);

            }
        });
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


}
