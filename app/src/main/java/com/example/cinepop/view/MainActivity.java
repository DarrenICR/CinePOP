package com.example.cinepop.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cinepop.Injection;
import com.example.cinepop.R;
import com.example.cinepop.controller.MainController;
import com.example.cinepop.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;
    private static Context appContext;

    private static final String KEY = "Save_Movie";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.movies_list);

        controller = new MainController(this, Injection.getRestApi());
        controller.onCreate();
    }

    public static Context getAppContext() { return appContext;
    }

    public void showList(List<Movie> movieList) {

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
    }

    public boolean isConnectionAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public void SetStock(List<Movie> movieList) {

        File folder = this.getFilesDir();
        File f= new File(folder, KEY);
        f.mkdir();

        Gson gson = new Gson();
        String json = gson.toJson(movieList);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        sharedPreferences
                .edit()
                .putString(KEY, json)
                .apply();
    }

    public List<Movie> GetStock() {

        sharedPreferences = getPreferences(MODE_PRIVATE);

        if (sharedPreferences != null) {
            Gson gson = new Gson();
            List<Movie> movieList;

            String string = sharedPreferences.getString(KEY, null);

            Type type = new TypeToken<List<Movie>>() {
            }.getType();
            movieList = gson.fromJson(string, type);
            return movieList;
        }
        return null;
    }
}
