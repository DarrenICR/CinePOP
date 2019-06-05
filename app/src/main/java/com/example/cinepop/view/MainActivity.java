package com.example.cinepop.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cinepop.Injection;
import com.example.cinepop.R;
import com.example.cinepop.controller.MainController;
import com.example.cinepop.model.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;
    private static Context appContext;

    private static final String KEY = "Movie_List";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.movies_list);

        controller = new MainController(this, Injection.getRestApi());
        controller.onCreate();
    }

    public void showList(List<Movie> movieList) {

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
    }
}
