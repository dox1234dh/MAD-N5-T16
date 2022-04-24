package com.example.mad_n5_t16;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DangKyHienMauActivityEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_hien_mau_employee);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}