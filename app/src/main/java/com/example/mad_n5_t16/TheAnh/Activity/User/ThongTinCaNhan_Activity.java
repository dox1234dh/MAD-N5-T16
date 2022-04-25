package com.example.mad_n5_t16.TheAnh.Activity.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.UserToolBar;
import com.example.mad_n5_t16.Public.model_class.NguoiHienMau;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.Public.model_class.DatabaseHelper;


public class ThongTinCaNhan_Activity extends AppCompatActivity {
    private TextView txtNameTitle, txtFullName, txtMainTitle;
    private FrameLayout btnThongtin, btnThongBao, btnDangXuat;
    public  static Activity activity;
    private NguoiHienMau nguoiHienMau;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_thongtincanhan);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        // Anh xa
        txtFullName = findViewById(R.id.textFullName);
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle.setText("Thông tin cá nhân");
        btnThongtin = findViewById(R.id.frameThongTinNguoiDung);
        btnThongBao = findViewById(R.id.frameThongBao);
        btnDangXuat = this.findViewById(R.id.frameDangXuat);

        //setup toolBar
        activity = this;
        UserToolBar bottomBar = new UserToolBar(this ,
                R.layout.activity_mh_thongtincanhan,
                findViewById(R.id.home),findViewById(R.id.marker),
                findViewById(R.id.heart_plus),
                findViewById(R.id.order_history),
                findViewById(R.id.guest_male) );

        //getdata
        btnThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinCaNhan_Activity.this, ChinhSuaThongTinCaNhan_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}