package com.example.mad_n5_t16.TheAnh.Activity.Employee;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.R;

public class DiaDiemHienMauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_employee_diadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}