package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mybible.adapters.BibleAdapter;

import static com.example.mybible.Contents.EshahName;
import static com.example.mybible.Contents.OldEshahIndex;

public class OldBibleActivity extends AppCompatActivity {
    Contents content;
    RecyclerView recyclerView;
    BibleAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldbible);
       // recyclerView=findViewById(R.id.o_recycler_view);
        recyclerView=findViewById(R.id.o_recycler_view);
        adapter=new BibleAdapter(Contents.OldBible);
        adapter.setOnItemClickListner(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {

                int indx=OldEshahIndex[pos];
                Toast.makeText(OldBibleActivity.this, indx+"", Toast.LENGTH_SHORT).show();

                 if(pos==18){
                     for(int i=1;i<=indx;i++){

                         EshahName.add( "مزمور"+"   "+i);
                     }
                 }
                 else{
                for(int i=1;i<=indx;i++){

                    EshahName.add( "اصحاح"+"   "+i);
                }}
                Toast.makeText(OldBibleActivity.this, pos+  name+"", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(OldBibleActivity.this,EshahActivity.class);
                startActivity(intent);


            }
        });

        layoutManager=new GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
