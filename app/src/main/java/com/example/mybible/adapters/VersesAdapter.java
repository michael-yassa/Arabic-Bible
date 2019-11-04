package com.example.mybible.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybible.EshahAdapter;
import com.example.mybible.R;

import java.util.ArrayList;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder> {
    ArrayList<String> verses;

    public VersesAdapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_verses,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
               String name = verses.get(position);
               holder.detail.setText(name);

    }

    @Override
    public int getItemCount() {
        if(verses==null)return 0;
        return verses.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView detail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //this.detail = detail;
            detail=itemView.findViewById(R.id.details);
        }
    }

}
