package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_n5_t16.MainActivity;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.ThongBaoActivity;

public class DangKyThanhCongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_dangkythanhcong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goHome = new Intent(DangKyThanhCongActivity.this, MainActivity.class);
                startActivity(goHome);
            }
        }, 1000);
    }
}