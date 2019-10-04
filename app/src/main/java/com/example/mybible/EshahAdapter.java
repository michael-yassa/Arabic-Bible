package com.example.mybible;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EshahAdapter extends RecyclerView.Adapter<EshahAdapter.ViewHolder> {


     ArrayList<String> EshahName;
   // String[]eshhhh;


    public EshahAdapter(ArrayList<String> eshahName) {
        EshahName = eshahName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_eshah_item,parent,false);
        return new EshahAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     final  String name=EshahName.get(position);
        holder.eshahItem.setText(name);

    }

    @Override
    public int getItemCount() {
        if(EshahName==null)return 0;
        return EshahName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
     TextView eshahItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eshahItem= itemView.findViewById(R.id.ishah_text);
        }
    }

}
