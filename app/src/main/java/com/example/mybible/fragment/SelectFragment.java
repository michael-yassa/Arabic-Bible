package com.example.mybible.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.mybible.NewBibleActivity;
import com.example.mybible.OldBibleActivity;
import com.example.mybible.R;




public class SelectFragment extends Fragment {

    public SelectFragment() {
    }

    Button newBible,oldBible;
    Fragment fragment = null;
   View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.activity_select,container,false);
        newBible=view.findViewById(R.id.new_bible);
        oldBible=view.findViewById(R.id.oldbible);

        newBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragment=new NewBibleFragment();


                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .commit();
            }
        });
        oldBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new OldBibleFragment();


                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .commit();
            }
            
        });
        return view;
    }

 /**   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        newBible=view.findViewById(R.id.new_bible);
        oldBible=findViewById(R.id.oldbible);

        oldBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  fragment[0] =new OldBibleFragment();
                Intent intent=new Intent(SelectFragment.this,OldBibleActivity.class );
                startActivity(intent);
            }
        });
        newBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectFragment.this, NewBibleActivity.class);
                startActivity(intent);
            }
        });
    }  **/
}
