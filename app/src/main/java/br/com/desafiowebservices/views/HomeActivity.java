package br.com.desafiowebservices.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.desafiowebservices.R;
import br.com.desafiowebservices.adapters.RecyclerviewHQsAdapter;
import br.com.desafiowebservices.interfaces.RecyclerviewClickListener;
import br.com.desafiowebservices.pojo.Result;
import br.com.desafiowebservices.viewlmodel.HQViewModel;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewhome;
    private RecyclerviewHQsAdapter recyclerviewHQsAdapter;
    //  private ProgressBar progressBar;
    private HQViewModel hqViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

        hqViewModel.getComics();

        hqViewModel.getResults().observe(this, (List<Result> results) -> {
            recyclerviewHQsAdapter.update(results);
        });
    }

    private void initViews() {
        hqViewModel = ViewModelProviders.of(this).get(HQViewModel.class);
        recyclerViewhome = findViewById(R.id.recyclerview_home_hq);
        //progressBar = findViewById(R.id.progressBar);
        recyclerviewHQsAdapter = new RecyclerviewHQsAdapter(new ArrayList<>());
        recyclerViewhome.setAdapter(recyclerviewHQsAdapter);
        recyclerViewhome.setLayoutManager(new GridLayoutManager(this, 3));


    }
}