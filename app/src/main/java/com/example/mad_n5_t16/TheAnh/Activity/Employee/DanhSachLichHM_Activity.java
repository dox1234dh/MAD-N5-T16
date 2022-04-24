package com.example.mad_n5_t16.TheAnh.Activity.Employee;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.R;

public class DanhSachLichHM_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_employee_danhsachlichhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}