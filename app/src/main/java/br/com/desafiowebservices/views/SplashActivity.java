package br.com.desafiowebservices.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.desafiowebservices.R;

public class SplashActivity extends AppCompatActivity {

    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView imageSplash = findViewById(R.id.imageSplash);
        imageSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);

    }

    private void jump() {
        timer.cancel();
        Intent goToMainActivity = new Intent(this, HomeActivity.class);
        startActivity(goToMainActivity);
        finish();
    }
}
