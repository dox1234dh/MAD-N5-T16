package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThongBaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh_thongbao);
        TextView titleBar = findViewById(R.id.txtHoVaTen);
        titleBar.setText("Thông báo");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ImageView markerNoti = findViewById(R.id.marker);
        markerNoti.setImageResource(R.drawable.marker_2);
        ImageView homeGo = findViewById(R.id.home);
        homeGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(ThongBaoActivity.this, MainActivity.class);
                startActivity(goHome);
            }
        });
    }
}