package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThongBaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_thongbao);
        TextView titleBar = findViewById(R.id.txtHoVaTen);
        titleBar.setText("Thông báo");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}