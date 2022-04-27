package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_n5_t16.Model.History;
import com.example.mad_n5_t16.Model.HistoryAdapter;
import com.example.mad_n5_t16.model_class.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;

public class BloodDonationHistoryActivity extends AppCompatActivity {
    private ListView lvDonationhistory;
    HistoryAdapter historyAdapter;
    private History[] histories;
    TextView txtHoVaTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation_history);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        lvDonationhistory = (ListView) findViewById(R.id.lvDonationhistory);
        txtHoVaTen = findViewById(R.id.txtHoVaTen);
        txtHoVaTen.setText("Lịch sử hiến máu");


        ArrayList<History> listHistory = new ArrayList<>();
        DatabaseHelper dbh = new DatabaseHelper(getBaseContext());

        //Sau nay lay gia tri tu nguoi dang nhap
        int idNguoiHienMau = 1;

        listHistory = dbh.nam_getLichSuHienMauByIdNguoiHienMau(idNguoiHienMau);
        int len = listHistory.size();
        histories = new History[len];
        for(int i = 0; i < histories.length; i++) {
            int time = listHistory.get(i).getNumber();
            int amount = listHistory.get(i).getAmount();
            String location = listHistory.get(i).getLocation();
            String date = listHistory.get(i).getDonationDate();
            histories[i] = new History(time, amount , location ,date );
        }
        if(histories.length > 0) {
            historyAdapter = new HistoryAdapter(this, histories);
            lvDonationhistory.setAdapter(historyAdapter);
        }else{
            Toast.makeText(this, "Bạn chưa đi hiến máu lần nào", Toast.LENGTH_SHORT).show();
        }
    }
}