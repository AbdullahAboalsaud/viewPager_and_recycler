package com.example.viewpager_and_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.viewpager_and_recycler.databinding.ActivityMain2Binding;

import java.util.ArrayList;

// todo:  recyclerView
public class MainActivity2 extends AppCompatActivity {


ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();

    }

    private void initData(){

    }

}