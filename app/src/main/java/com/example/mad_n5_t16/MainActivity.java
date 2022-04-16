package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCallActivity1;
    private Button btnCallActivity2;
    private Button btnCallActivity3;
    private Button btnCallActivity4;
    private Button btnCallActivity5;
    private Button btnCallActivity6;
    private Button btnHuongDangKy;
    private Button btnHuongDangNhap;
    private Button btnHuongLichSuHienMau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnCallActivity1 = (Button) findViewById(R.id.btnCallActivity1);
        btnHuongDangNhap = (Button) findViewById(R.id.btnHuongDangNhap);
        btnHuongDangKy = (Button) findViewById(R.id.btnHuongDangKy);
        btnHuongLichSuHienMau = (Button) findViewById(R.id.btnHuongLichSuHienMau);

        btnCallActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongBaoActivity.class);
                startActivity(intent);
            }
        });

        btnHuongDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnHuongDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnHuongLichSuHienMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BloodDonationHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}