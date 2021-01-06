package com.blogspot.recycleview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.recycleview.Models.foodModels;
import com.blogspot.recycleview.R;
import com.blogspot.recycleview.onclick.onitem;

import java.util.ArrayList;

public class FoodAdapters extends RecyclerView.Adapter<FoodAdapters.ViewHolder> {
    Context context;
    ArrayList<foodModels> list;
    onitem recycleView;

    public FoodAdapters(Context context, ArrayList<foodModels> list, onitem recycleView) {
        this.context = context;
        this.list = list;
        this.recycleView = recycleView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(R.layout.recycleview_resources,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImageId());
        holder.text.setText(list.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.text1);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   recycleView.OnItemClick(getAdapterPosition());
               }
           });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    recycleView.LongOnItemClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
