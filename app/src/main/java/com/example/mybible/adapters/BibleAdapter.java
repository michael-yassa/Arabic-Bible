package com.example.mybible.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybible.R;

public class BibleAdapter extends RecyclerView.Adapter<BibleAdapter.ViewHolder> {

    String names[];

    public BibleAdapter(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public BibleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item,parent,false);
        return new BibleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BibleAdapter.ViewHolder holder, final int position) {
         final String name= names[position];
        holder.itemText.setText(name);
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //callback
                    onItemClickListener.onItemClick(position,name);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(names ==null) return 0;
        return names.length;

    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListner(OnItemClickListener onItemClickListner) {
        this.onItemClickListener = onItemClickListner;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,String name);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText=itemView.findViewById(R.id.item_text);
        }
    }
}
