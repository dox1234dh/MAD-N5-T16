package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mad_n5_t16.R;

public class DienThongTinDangKyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_dienthongtindangky);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}