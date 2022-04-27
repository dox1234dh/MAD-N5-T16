package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_n5_t16.model_class.DatabaseHelper;
import com.example.mad_n5_t16.model_class.TaiKhoan;


public class ThongBaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_thongbao);
        TextView titleBar = findViewById(R.id.txtHoVaTen);
        titleBar.setText("Thông báo");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ImageView markerNoti = findViewById(R.id.marker);
        markerNoti.setImageResource(R.drawable.marker_2);
//        ImageView homeGo = findViewById(R.id.home);
//        homeGo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent goHome = new Intent(ThongBaoActivity.this, MainActivity.class);
//                startActivity(goHome);
//            }
//        });
        TaiKhoan taikhoanTest = new TaiKhoan("1","1","Trịnh Tiến Đạt", "khachhang");
        taikhoanTest.setId(1);
        DatabaseHelper dbh = new DatabaseHelper((getBaseContext()));
        Log.d("taikhoan", "onCreate: "+ dbh.nam_getTaiKhoanByUserNameAndPassWord("1","1").getMatKhau());
        if(taikhoanTest.getMatKhau().equals(dbh.nam_getTaiKhoanByUserNameAndPassWord("1", "1").getMatKhau())){
//            String dt = dbh.dat_getNguoiHienMau(taikhoanTest).getNgaySinh();
//            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/mm/yyyy");
//            Calendar c = Calendar.getInstance();
//            try {
//                c.setTime(sdf.parse(dt));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            c.add(Calendar.DATE, 1); // number of days to add.
//            Log.i("Date", "onCreate: " + dbh.dat_getNguoiHienMau(taikhoanTest).getNgaySinh());
//            Log.i("Date", "onCreate: " + sdf.format(c.getTime()));
        }
    }
}