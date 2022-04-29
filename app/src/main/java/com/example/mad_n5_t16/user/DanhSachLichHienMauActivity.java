package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mad_n5_t16.R;

import java.util.ArrayList;

public class DanhSachLichHienMauActivity extends AppCompatActivity {
    ArrayList<ItemModelDanhSachLichHienMauActivity> ls;
    DanhSachLichHienMauItem adapter;
    ListView listView;
    ImageButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_danhsachlichhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView toolbar = findViewById(R.id.txtHoVaTen);
        toolbar.setText("Lịch hiến máu của tôi");
        ImageView markerNoti = findViewById(R.id.heart_plus);
        markerNoti.setImageResource(R.drawable.heart_plus_2);
        ls = new ArrayList<>();
        // Lay data
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Viện Huyết học - Truyền máu TW, Địa điểm :Phạm Văn Bạch, Yên Hòa, Cầu Giấy, Hà Nội"));
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Phòng khám Đa Khoa Số 26 Phố Lương Ngọc Quyển, Hoàn Kiếm, Hà Nội"));
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Phòng khám Đa Khoa Số 26 Phố Lương Ngọc Quyển, Hoàn Kiếm, Hà Nội"));
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Phòng khám Đa Khoa Số 26 Phố Lương Ngọc Quyển, Hoàn Kiếm, Hà Nội"));
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Phòng khám Đa Khoa Số 26 Phố Lương Ngọc Quyển, Hoàn Kiếm, Hà Nội"));
        ls.add(new ItemModelDanhSachLichHienMauActivity("28","T2-2022","07:30 - 11:00","Phòng khám Đa Khoa Số 26 Phố Lương Ngọc Quyển, Hoàn Kiếm, Hà Nội"));

        adapter = new DanhSachLichHienMauItem(ls);
        listView = findViewById(R.id.dotv_list_danhsachlichhienmau);
        listView.setAdapter(adapter);
        add = findViewById(R.id.dotv_btnadd_danhsachlichhienmau);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangky = new Intent(DanhSachLichHienMauActivity.this, DangKyHienMauActivity.class);
                startActivity(dangky);
            }
        });
    }
}

class ItemModelDanhSachLichHienMauActivity{
    String ngay, thang_nam,thoigian, diadiem;

    public ItemModelDanhSachLichHienMauActivity(String ngay, String thang_nam, String thoigian, String diadiem) {
        this.ngay = ngay;
        this.thang_nam = thang_nam;
        this.thoigian = thoigian;
        this.diadiem = diadiem;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThang_nam() {
        return thang_nam;
    }

    public void setThang_nam(String thang_nam) {
        this.thang_nam = thang_nam;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }
}

class DanhSachLichHienMauItem extends BaseAdapter {

    final ArrayList<ItemModelDanhSachLichHienMauActivity> ls;

    public DanhSachLichHienMauItem(ArrayList<ItemModelDanhSachLichHienMauActivity> ls) {
        this.ls = ls;
    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int i) {
        return ls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewItem1;
        if (view == null) {
            viewItem1 = View.inflate(viewGroup.getContext(), R.layout.dotv_layout_items_dangsachlichhienmau, null);
        } else viewItem1 = view;

        ItemModelDanhSachLichHienMauActivity items = (ItemModelDanhSachLichHienMauActivity) getItem(i);
        ((TextView)viewItem1.findViewById(R.id.dotv_ngay_danhsachlichhienmau)).setText(items.getNgay());
        ((TextView)viewItem1.findViewById(R.id.dotv_thangnam_danhsachlichhienmau)).setText(items.getThang_nam());
        ((TextView)viewItem1.findViewById(R.id.dotv_thoigian_danhsachlichhienmau)).setText(items.getThoigian());
        ((TextView)viewItem1.findViewById(R.id.dotv_diadiem_danhsachlichhienmau)).setText(items.getDiadiem());
        ImageButton btnDel = viewItem1.findViewById(R.id.dotv_btndel_danhsachlichhienmau);
        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("index", "onClick: " + i);
                //delete record by id
            }

        });

        return viewItem1;
    }
}
