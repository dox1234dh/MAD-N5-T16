package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.mad_n5_t16.MainActivityEmployee;
import com.example.mad_n5_t16.MainActivityUser;
import com.example.mad_n5_t16.TheAnh.Activity.User.ThongTinCaNhan_Activity;
public class MainActivity extends AppCompatActivity {
    private Button btnCallActivity1;
    private Button btnTTCaNhan;
    private Button btnCallActivity3;
    private Button btnCallActivity4;
    private Button btnCallActivity5;
    private Button btnCallActivity6;
    private Button btnHuongDangKy;
    private Button btnHuongDangNhap;
    private Button btnHuongLichSuHienMau;
    private Button btnMHChinhUser;
    private Button btnMHChinhEmployee;


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
        btnMHChinhUser = (Button) findViewById(R.id.btnMHChinhUser);
        btnMHChinhEmployee = (Button) findViewById(R.id.btnMHChinhEmployee);
        btnTTCaNhan = findViewById(R.id.btnThongtinnguoidung);

        btnCallActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongBaoActivity.class);
                startActivity(intent);
            }
        });


//        btnMHChinhUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivityUser.class);
//                startActivity(intent);
//            }
//        });
        btnMHChinhEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityEmployee.class);
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

        btnTTCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongTinCaNhan_Activity.class);
                startActivity(intent);
            }
        });
    }
}