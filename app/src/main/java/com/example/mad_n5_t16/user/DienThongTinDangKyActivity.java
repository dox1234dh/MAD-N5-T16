package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.databinding.DotvLayoutDienthongtindangkyBinding;
import com.example.mad_n5_t16.databinding.DotvLayoutItemsCauhoiDienthongtindangkyBinding;

public class DienThongTinDangKyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_dienthongtindangky);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView toolbar = findViewById(R.id.txtHoVaTen);
        toolbar.setText("Thông tin đăng ký");
        DotvLayoutDienthongtindangkyBinding binding = DotvLayoutDienthongtindangkyBinding.inflate(getLayoutInflater());
        binding.dotvCauhoi1Dienthongtindangky.dotvIndexDienthongtindangky.setText("1");
        Log.i("checking", "Dienthongtindangky: " + binding.dotvCauhoi1Dienthongtindangky.dotvCauhoiDienthongtindangky.getText());
        binding.dotvCauhoi1Dienthongtindangky.dotvCauhoiDienthongtindangky.setText("Cau hoi 1");
        Log.i("checking", "Dienthongtindangky: " + binding.dotvCauhoi1Dienthongtindangky.dotvCauhoiDienthongtindangky.getText());
        binding.dotvCauhoi2Dienthongtindangky.dotvIndexDienthongtindangky.setText("2");
        binding.dotvCauhoi2Dienthongtindangky.dotvCauhoiDienthongtindangky.setText("Cau hoi 2");
        Log.i("checking", "Dienthongtindangky: " + binding.dotvCauhoi2Dienthongtindangky.dotvCauhoiDienthongtindangky.getText());
        binding.dotvCauhoi3Dienthongtindangky.dotvIndexDienthongtindangky.setText("3");
        binding.dotvCauhoi3Dienthongtindangky.dotvCauhoiDienthongtindangky.setText("Cau hoi 3");
        Log.i("checking", "Dienthongtindangky: " + binding.dotvCauhoi3Dienthongtindangky.dotvCauhoiDienthongtindangky.getText());
        binding.dotvCauhoi4Dienthongtindangky.dotvIndexDienthongtindangky.setText("4");
        binding.dotvCauhoi4Dienthongtindangky.dotvCauhoiDienthongtindangky.setText("Cau hoi 4");
        Log.i("checking", "Dienthongtindangky: " + binding.dotvCauhoi4Dienthongtindangky.dotvCauhoiDienthongtindangky.getText());
    }
}