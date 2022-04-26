package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import java.util.Date;

public class BloodDonationHistoryActivity extends AppCompatActivity {
    private ListView lvDonationhistory;
//    HistoryAdapter historyAdapter;
//    private History[] histories;
    TextView txtHoVaTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation_history);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        lvDonationhistory = (ListView) findViewById(R.id.lvDonationhistory);
        initData();
        txtHoVaTen.setText("Lịch sử hiến máu");
//        historyAdapter = new HistoryAdapter(this, histories);
//        lvDonationhistory.setAdapter(historyAdapter);
    }

    private void initData() {
        int[] times = {1, 2, 3};
        String[] dates = {"02/12/2020","02/12/2020","02/12/2020"}; // xem lai date
        int[] amounts = {350, 350, 350};
        String[] locations = {"Học viện Bưu chính Viễn Thông","Học viện Bưu chính Viễn Thông","Học viện Bưu chính Viễn Thông"};
        txtHoVaTen = findViewById(R.id.txtHoVaTen);
//        histories = new History[times.length];
//        for(int i = 0; i < histories.length; i++) {
//            histories[i] = new History(times[i], amounts[i], locations[i], dates[i]);
//        }
    }
}