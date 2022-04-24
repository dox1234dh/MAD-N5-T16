package com.example.mad_n5_t16.TheAnh.Activity.User;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.R;

public class ChinhSuaThongTinCaNhan_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_mh_thongtincanhan2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}