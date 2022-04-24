package com.example.mad_n5_t16.TheAnh.Activity.User;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.MainActivity;
import com.example.mad_n5_t16.MainActivityEmployee;
import com.example.mad_n5_t16.Public.UserToolBar;
import com.example.mad_n5_t16.R;


public class ThongTinCaNhan_Activity extends AppCompatActivity {
    private TextView txtNameTitle, txtFullName, txtMainTitle;
    private FrameLayout btnThongtin, btnThongBao, btnDangXuat;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_thongtincanhan);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        txtFullName = findViewById(R.id.textFullName);
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle.setText("Thông tin cá nhân");
        btnThongtin = findViewById(R.id.frameThongTinNguoiDung);
        btnThongBao = findViewById(R.id.frameThongBao);
        btnDangXuat = this.findViewById(R.id.frameDangXuat);
        UserToolBar bottomBar = new UserToolBar(this ,
                R.layout.activity_mh_thongtincanhan,
                findViewById(R.id.home),findViewById(R.id.marker),
                findViewById(R.id.heart_plus),
                findViewById(R.id.order_history),
                findViewById(R.id.guest_male) );
        btnThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ThongTinCaNhan_Activity.this, ChinhSuaThongTinCaNhan_Activity.class);
                startActivity(intent);
            }
        });
    }
}