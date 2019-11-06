package com.example.mybible.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybible.Contents;
import com.example.mybible.EshahActivity;
import com.example.mybible.R;
import com.example.mybible.VersesShowActivity;
import com.example.mybible.adapters.BibleAdapter;

import static com.example.mybible.Contents.EshahIndex;
import static com.example.mybible.Contents.EshahName;
//import static com.example.mybible.EshahAdapter.EshahNamee;


public class NewBibleFragment extends Fragment {


    public NewBibleFragment(){

    }
    Contents content;
    RecyclerView recyclerView;
    BibleAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

       View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.activity_new_bible, container, false);


        recyclerView=view.findViewById(R.id.n_recycler_view);
        adapter=new BibleAdapter(Contents.NewBible);
        adapter.setOnItemClickListner(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {


                int indx=EshahIndex[pos];
              //  Toast.makeText(NewBibleFragment.this, indx+"", Toast.LENGTH_SHORT).show();


                for(int i=1;i<=indx;i++){
                    EshahName.add( "اصحاح"+"   "+i);
                }
              //  Toast.makeText(getContext(), pos+  name+"", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),EshahActivity.class);
                intent.putExtra("pos",pos);
                intent.putExtra("name",name);
                Toast.makeText(getContext(), pos+"", Toast.LENGTH_SHORT).show();
              //  intent.putExtra("indx",indx);
                startActivity(intent);


            }
        });

        layoutManager=new GridLayoutManager(getContext(),2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }


    // @Override
  /**  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bible);
        recyclerView=findViewById(R.id.n_recycler_view);
        adapter=new BibleAdapter(Contents.NewBible);
       adapter.setOnItemClickListner(new BibleAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int pos, String name) {

               int indx=EshahIndex[pos];
               Toast.makeText(NewBibleFragment.this, indx+"", Toast.LENGTH_SHORT).show();


               for(int i=1;i<=indx;i++){
                   EshahName.add( "اصحاح"+"   "+i);
               }
               Toast.makeText(NewBibleFragment.this, pos+  name+"", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(NewBibleFragment.this,EshahActivity.class);
               startActivity(intent);


           }
       });

        layoutManager=new GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }  **/
}

