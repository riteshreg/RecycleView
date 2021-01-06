package com.blogspot.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.blogspot.recycleview.Adapters.FoodAdapters;
import com.blogspot.recycleview.Models.foodModels;

import com.blogspot.recycleview.onclick.onitem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onitem {

    RecyclerView recyclerView;
    ArrayList<foodModels> list;
    FoodAdapters adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<foodModels>();
        list.add(new foodModels(R.drawable.img1,"Bird1"));
        list.add(new foodModels(R.drawable.img2,"Bird2"));
        list.add(new foodModels(R.drawable.img5,"Bird3"));
        list.add(new foodModels(R.drawable.img4,"Bird4"));
        list.add(new foodModels(R.drawable.img6,"Bird5"));
        list.add(new foodModels(R.drawable.img7,"Bird6"));

         adapters = new FoodAdapters(this,list,this);
        recyclerView.setAdapter(adapters);
    }

    @Override
    public void OnItemClick(int position) {
        Toast.makeText(this, "Clicked Register", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LongOnItemClick(int position) {
        list.remove(position);
        adapters.notifyItemChanged(position);
    }
}