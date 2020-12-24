package com.majime.shopc.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.majime.shopc.R;
import com.majime.shopc.data.Data;
import com.majime.shopc.ui.login.LoginActivity;
import com.majime.shopc.ui.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash_screen);

        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        ImageView ivLogo = findViewById(R.id.iv_logo_splash_screen);
        TextView tvDeveloper = findViewById(R.id.tv_developer_splash_screen);

        ivLogo.setAnimation(topAnim);
        tvDeveloper.setAnimation(bottomAnim);

        int splashDelay = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Data.isLogged) {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, splashDelay);
    }

}