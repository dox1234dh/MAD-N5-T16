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
import com.example.mad_n5_t16.Public.model_class.DatabaseHelper;
import com.example.mad_n5_t16.Public.model_class.LichHienMau;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DanhSachLichHienMauActivity extends AppCompatActivity {
    ArrayList<ItemModelDanhSachLichHienMauActivity> ls;
    DanhSachLichHienMauItem adapter;
    ListView listView;
    ImageButton add;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_danhsachlichhienmau);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        TextView toolbar = findViewById(R.id.textTitle);
        toolbar.setText("Lịch hiến máu của tôi");
        ImageView markerNoti = findViewById(R.id.heart_plus);
        markerNoti.setImageResource(R.drawable.heart_plus_2);
        ls = new ArrayList<>();
        dbh = new DatabaseHelper(getBaseContext());
        // fix cứng tìm khánh hàng có id mã đăng ký hiến máu 1
        ArrayList<LichHienMau> data = dbh.do_layDsLichHienMau(1);
        // Lay data
        for(int i=0;i<data.size();++i){
            initDate date = validate(data.get(i).getThoiGian().getNgay());
            ls.add(new ItemModelDanhSachLichHienMauActivity(
                    date.ngay,
                    date.thang_nam,
                    data.get(i).getThoiGian().getGioBatDau() + " - " + data.get(i).getThoiGian().getGioKetThuc(),
                    data.get(i).getDiaDiem().getTenDiaDiem()));
        }
        adapter = new DanhSachLichHienMauItem(ls);
        listView = findViewById(R.id.dotv_list_danhsachlichhienmau);
        listView.setAdapter(adapter);
        add = findViewById(R.id.dotv_btnadd_danhsachlichhienmau);
        add.setOnClickListener(view -> {
            Intent dangky = new Intent(DanhSachLichHienMauActivity.this, DangKyHienMauActivity.class);
            startActivity(dangky);
        });
    }
    public initDate validate(String date){
        String ngay = "";
        String thang_nam = "";
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy/MM/dd");
        Date result;
        try {
            result = sfd.parse(date);
            Calendar cal = Calendar.getInstance();
            assert result != null;
            cal.setTime(result);
            thang_nam ="T"+ cal.get(Calendar.MONTH) +"-"+cal.get(Calendar.YEAR);
            ngay = cal.get(Calendar.DAY_OF_MONTH) + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new initDate(ngay, thang_nam);
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
        btnDel.setOnClickListener(v -> {
            Log.i("index", "onClick: " + i);
            //delete record by id
        });

        return viewItem1;
    }
}
