package com.example.mad_n5_t16.TheAnh.Activity.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.model_class.DiaDiem;
import com.example.mad_n5_t16.Public.model_class.LichHienMau;
import com.example.mad_n5_t16.Public.model_class.ThoiGian;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.TheAnh.ModelAdapter.ThoiGianCuaDiaDiemAdapter;

import java.util.ArrayList;

public class DanhSachLichHM_Activity extends AppCompatActivity {
    ThoiGianCuaDiaDiemAdapter thoiGianCuaDiaDiemAdapter;
    ArrayList<LichHienMau> list;
    ListView listView;
    ImageButton btnThem;
    TextView txtNameTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_employee_danhsachlichhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        listView = findViewById(R.id.listLichHien);
        btnThem = findViewById(R.id.imagethemlich);
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle.setText("Danh sách lịch hiến máu");
        list = new ArrayList<>();
        ThoiGian thoiGian1 = new ThoiGian("2022/11/12","7:00", "11:00");
        ThoiGian thoiGian2 = new ThoiGian("2022/11/13","5:00", "12:00");
        DiaDiem diaDiem1 = new DiaDiem("Hoc vien BCVT 1");
        DiaDiem diaDiem2 = new DiaDiem("Hoc vien BCVT 2");
        LichHienMau lichHienMau1 = new LichHienMau(thoiGian1, "xxx", diaDiem1);
        LichHienMau lichHienMau2 = new LichHienMau(thoiGian2, "xxx", diaDiem2);
        list.add(lichHienMau1);
        list.add(lichHienMau2);

        thoiGianCuaDiaDiemAdapter = new ThoiGianCuaDiaDiemAdapter(list, this, R.layout.item_thoigiancuadiadiem);
        listView.setAdapter(thoiGianCuaDiaDiemAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachLichHM_Activity.this, ThemLichHienMau_Activity.class);
                startActivity(intent);
            }
        });
    }
}