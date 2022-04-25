package com.example.mad_n5_t16.TheAnh.Activity.User;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.UserToolBar;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.Public.model_class.DatabaseHelper;
import com.example.mad_n5_t16.Public.model_class.DiaDiem;

import java.util.ArrayList;

public class DiaDiem_Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ArrayList<DiaDiem> listDiaDiem;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_diadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //getdata
        databaseHelper = new DatabaseHelper(this);
        listDiaDiem = new ArrayList<>();
        listDiaDiem = databaseHelper.getAllDiaDiem();
        listDiaDiem.forEach(diaDiem -> {
            System.out.println(diaDiem.getTenDiaDiem());
        });
        listDiaDiem = databaseHelper.searchDiaDiem("Hoc");
        listDiaDiem.forEach(diaDiem -> {
            System.out.println("----"+diaDiem.getTenDiaDiem());
        });
        UserToolBar bottomBar = new UserToolBar(DiaDiem_Activity.this ,
                R.layout.activity_mh_diadiemhienmau,
                findViewById(R.id.home),findViewById(R.id.marker),
                findViewById(R.id.heart_plus),
                findViewById(R.id.order_history),
                findViewById(R.id.guest_male) );
    }
}