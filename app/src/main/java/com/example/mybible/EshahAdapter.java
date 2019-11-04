package com.example.mybible;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EshahAdapter extends RecyclerView.Adapter<EshahAdapter.ViewHolder> {


     List<String> EshahName;



    public EshahAdapter(List<String> eshahName) {
        EshahName = eshahName;
    }

    public void updateData(){
        EshahName.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_eshah_item,parent,false);
        return new EshahAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
     final  String name=EshahName.get(position);
        holder.eshahItem.setText(name);
        if(onclickLisetner !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onclickLisetner.onItemClick(position,name);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(EshahName==null)return 0;
        return EshahName.size();
    }

           OnclickLisetner onclickLisetner;

    public void setOnclickLisetner(OnclickLisetner onclickLisetner) {
        this.onclickLisetner = onclickLisetner;
    }

    public interface OnclickLisetner{
             void onItemClick(int pos,String name);

           }

    public class ViewHolder extends RecyclerView.ViewHolder{
     TextView eshahItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eshahItem= itemView.findViewById(R.id.ishah_text);
        }
    }

}
