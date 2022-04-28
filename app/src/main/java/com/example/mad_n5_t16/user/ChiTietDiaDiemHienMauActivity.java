package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.model_class.DatabaseHelper;
import com.example.mad_n5_t16.model_class.ThoiGian;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChiTietDiaDiemHienMauActivity extends AppCompatActivity {
    ArrayList<ItemModelChiTietDiaDiemHienMauActivity> ls;
    ChiTietDiaDiemHienMauItems adapter;
    ListView listView;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotv_layout_chitietdiadiemhienmau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView toolbar = findViewById(R.id.txtHoVaTen);
        toolbar.setText("Lịch hiến máu");
        ImageView markerNoti = findViewById(R.id.marker);
        markerNoti.setImageResource(R.drawable.marker_2);
        ls = new ArrayList<>();
        dbh = new DatabaseHelper(getBaseContext());
        ArrayList<ThoiGian> lsTg = dbh.do_getThoiGian();
        for(int i = 0 ;i< lsTg.size();++i){
            initDate date = validate(lsTg.get(i).getNgay());
            ls.add(new ItemModelChiTietDiaDiemHienMauActivity(date.ngay,date.thang_nam,lsTg.get(i).getGioBatDau() + " - " + lsTg.get(i).getGioKetThuc(),"Hiến máu cứu người"));
        }
        // Lay data
        adapter = new ChiTietDiaDiemHienMauItems(ls);
        listView = findViewById(R.id.dotv_list_chitietdiadiemhienmau);
        listView.setAdapter(adapter);
    }
    public initDate validate(String date){
        String ngay = "";
        String thang_nam = "";
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy/MM/dd");
        Date result;
        try {
            result = sfd.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(result);
            thang_nam ="T"+ cal.get(Calendar.MONTH) +"-"+cal.get(Calendar.YEAR);
            ngay = cal.get(Calendar.DAY_OF_MONTH) + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new initDate(ngay, thang_nam);
    }
}
class initDate{
    String ngay, thang_nam;
    public initDate(String ngay, String thang_nam){
        this.ngay = ngay;
        this.thang_nam = thang_nam;
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
