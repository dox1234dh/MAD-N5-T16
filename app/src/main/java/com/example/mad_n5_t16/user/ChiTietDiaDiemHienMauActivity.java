package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mad_n5_t16.R;

import java.util.ArrayList;

public class ChiTietDiaDiemHienMauActivity extends AppCompatActivity {
    ArrayList<ItemModelChiTietDiaDiemHienMauActivity> ls;
    ChiTietDiaDiemHienMauItems adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_chitietdiadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView toolbar = findViewById(R.id.txtHoVaTen);
        toolbar.setText("Lịch hiến máu");
        ls = new ArrayList<>();
        // Lay data
        ls.add(new ItemModelChiTietDiaDiemHienMauActivity("28","T2-2022","07:30-11:00","Hiến máu cứu người"));
        ls.add(new ItemModelChiTietDiaDiemHienMauActivity("28","T2-2022","13:00-17:00","Hiến máu cứu người"));
        ls.add(new ItemModelChiTietDiaDiemHienMauActivity("2","T3-2022","07:30-11:00","Hiến máu cứu người"));

        adapter = new ChiTietDiaDiemHienMauItems(ls);
        listView = findViewById(R.id.dotv_list_chitietdiadiemhienmau);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChiTietDiaDiemHienMauActivity.this, DienThongTinDangKyActivity.class);
//                String message = "abc";
//                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}

class ItemModelChiTietDiaDiemHienMauActivity{
    String ngay,thang_nam,thoigian, tieude;

    public ItemModelChiTietDiaDiemHienMauActivity(String ngay, String thang_nam, String thoigian, String tieude) {
        this.ngay = ngay;
        this.thang_nam = thang_nam;
        this.thoigian = thoigian;
        this.tieude = tieude;
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

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }
}

class ChiTietDiaDiemHienMauItems extends BaseAdapter {

    final ArrayList<ItemModelChiTietDiaDiemHienMauActivity> ls;

    public ChiTietDiaDiemHienMauItems(ArrayList<ItemModelChiTietDiaDiemHienMauActivity> ls) {
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
        View viewItem;
        if (view == null) {
            viewItem = View.inflate(viewGroup.getContext(), R.layout.dotv_layout_items_chitietdiadiemhienmau, null);
        } else viewItem = view;

        ItemModelChiTietDiaDiemHienMauActivity items = (ItemModelChiTietDiaDiemHienMauActivity) getItem(i);
        ((TextView)viewItem.findViewById(R.id.dotv_ngay_chitietdiadiemhienmau)).setText(items.getNgay());
        ((TextView)viewItem.findViewById(R.id.dotv_thangnam_chitietdiadiemhienmau)).setText(items.getThang_nam());
        ((TextView)viewItem.findViewById(R.id.dotv_thoigian_chitietdiadiemhienmau)).setText(items.getThoigian());
        ((TextView)viewItem.findViewById(R.id.dotv_tieude_chitietdiadiemhienmau)).setText(items.getTieude());
        return viewItem;
    }
}
