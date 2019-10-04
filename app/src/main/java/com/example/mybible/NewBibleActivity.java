package com.example.mybible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mybible.adapters.BibleAdapter;

import static com.example.mybible.Contents.EshahIndex;
import static com.example.mybible.Contents.EshahName;
//import static com.example.mybible.EshahAdapter.EshahNamee;


public class NewBibleActivity extends AppCompatActivity {
    Contents content;
    RecyclerView recyclerView;
    BibleAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bible);
        recyclerView=findViewById(R.id.n_recycler_view);
        adapter=new BibleAdapter(Contents.NewBible);
       adapter.setOnItemClickListner(new BibleAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int pos, String name) {

               int indx=EshahIndex[pos];
               Toast.makeText(NewBibleActivity.this, indx+"", Toast.LENGTH_SHORT).show();


               for(int i=1;i<=indx;i++){
                   EshahName.add( "اصحاح"+"   "+i);
               }
               Toast.makeText(NewBibleActivity.this, pos+  name+"", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(NewBibleActivity.this,EshahActivity.class);
               startActivity(intent);


           }
       });

        layoutManager=new GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
