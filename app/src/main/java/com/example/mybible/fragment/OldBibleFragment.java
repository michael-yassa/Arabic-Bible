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
import com.example.mybible.adapters.BibleAdapter;

import static com.example.mybible.Contents.EshahName;
import static com.example.mybible.Contents.OldEshahIndex;

public class OldBibleFragment extends Fragment {
      public OldBibleFragment(){

      }

    Contents content;
    RecyclerView recyclerView;
    BibleAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
     View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_oldbible,container,false);

        recyclerView=view.findViewById(R.id.o_recycler_view);
        adapter=new BibleAdapter(Contents.OldBible);
        adapter.setOnItemClickListner(new BibleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {

                int indx=OldEshahIndex[pos];
                Toast.makeText(getActivity(), indx+"", Toast.LENGTH_SHORT).show();

                if(pos==18){
                    for(int i=1;i<=indx;i++){

                        EshahName.add( "مزمور"+"   "+i);
                    }
                }
                else{
                    for(int i=1;i<=indx;i++){

                        EshahName.add( "اصحاح"+"   "+i);
                    }}
                Toast.makeText(getContext(), pos+  name+"", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),EshahActivity.class);
                intent.putExtra("pos",pos);
                startActivity(intent);


            }
        });

        layoutManager=new GridLayoutManager(getContext(),2,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }


}
