package com.example.mad_n5_t16.TheAnh.Activity.User;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.UserToolBar;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.Public.model_class.DatabaseHelper;
import com.example.mad_n5_t16.Public.model_class.DiaDiem;
import com.example.mad_n5_t16.TheAnh.ModelAdapter.DiaDiemHienMauAdapter;
import com.example.mad_n5_t16.user.ChiTietDiaDiemHienMauActivity;

import java.util.ArrayList;

public class DiaDiem_Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ArrayList<DiaDiem> listDiaDiem;
    ListView listView;
    SearchView txtSearch;
    DiaDiemHienMauAdapter diaDiemHienMauAdapter;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_diadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        listView = findViewById(R.id.listDiadiemuser);
        txtSearch = findViewById(R.id.txtSearch);
        //getdata
        databaseHelper = new DatabaseHelper(this);
        listDiaDiem = new ArrayList<>();
        getData("");


        UserToolBar bottomBar = new UserToolBar(DiaDiem_Activity.this ,
                R.layout.activity_mh_diadiemhienmau,
                findViewById(R.id.home),findViewById(R.id.marker),
                findViewById(R.id.heart_plus),
                findViewById(R.id.order_history),
                findViewById(R.id.guest_male) );
        txtSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getData(newText);
                return true;
            }
        });
        ImageView markerNoti = findViewById(R.id.marker);
        markerNoti.setImageResource(R.drawable.marker_2);
        markerNoti.setOnClickListener(view -> {
            Intent goDetail = new Intent(DiaDiem_Activity.this, ChiTietDiaDiemHienMauActivity.class);
            startActivity(goDetail);
        });
    }
    public void  getData(String search){
        if(search.length() == 0){
            listDiaDiem = databaseHelper.getAllDiaDiem();
        } else {
            listDiaDiem = databaseHelper.searchDiaDiem(search);
        }
        diaDiemHienMauAdapter = new DiaDiemHienMauAdapter(listDiaDiem ,this, R.layout.item_diadiemhienmau);
        listView.setAdapter(diaDiemHienMauAdapter);
    }
}