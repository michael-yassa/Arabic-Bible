package com.example.mybible.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mybible.Contents;
import com.example.mybible.R;

public class SelectMofaserFragment extends Fragment {
    public SelectMofaserFragment() {
    }

    TextView f_tadros,f_antonyous;
    Fragment fragment = null;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.activity_mofaser,container,false);

        f_tadros = view.findViewById(R.id.text1);
        f_antonyous = view.findViewById(R.id.text2);

        f_tadros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Contents.mofaserName = "f_tadros";
                 openSelector();

            }
        });
        f_antonyous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contents.mofaserName = "f_antonyous";
             openSelector();




            }

        });
        return view;
    }
    public void openSelector(){


        fragment = new SelectFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();



    }

}
