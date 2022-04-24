package com.example.mad_n5_t16.TheAnh.Activity.User;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.UserToolBar;
import com.example.mad_n5_t16.R;

public class DiaDiem_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_diadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        UserToolBar bottomBar = new UserToolBar(DiaDiem_Activity.this ,
                R.layout.activity_mh_diadiemhienmau,
                findViewById(R.id.home),findViewById(R.id.marker),
                findViewById(R.id.heart_plus),
                findViewById(R.id.order_history),
                findViewById(R.id.guest_male) );
    }
}