package br.com.desafiowebservices.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import br.com.desafiowebservices.R;
import br.com.desafiowebservices.adapters.RecyclerviewHQsAdapter;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewhome;
    private RecyclerviewHQsAdapter recyclerviewHQsAdapter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
    }

    private void initViews() {

    }
}
