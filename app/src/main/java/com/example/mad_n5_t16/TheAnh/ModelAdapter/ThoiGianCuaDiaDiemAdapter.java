package com.example.mad_n5_t16.TheAnh.ModelAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mad_n5_t16.Public.model_class.DiaDiem;
import com.example.mad_n5_t16.Public.model_class.LichHienMau;
import com.example.mad_n5_t16.R;

import java.util.ArrayList;

public class ThoiGianCuaDiaDiemAdapter extends BaseAdapter {
    final ArrayList<LichHienMau> listData;
    private Context context;
    private int layout;
    public ThoiGianCuaDiaDiemAdapter(ArrayList<LichHienMau> listData, Context context, int layout) {
        this.listData = listData;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return  listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView textNgay, textThang, textGioDiaDiem;
        Button btnXoa;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ThoiGianCuaDiaDiemAdapter.ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater infalter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalter.inflate(layout, null);
            viewHolder = new ThoiGianCuaDiaDiemAdapter.ViewHolder();

            viewHolder.textNgay = convertView.findViewById(R.id.textNgay);
            viewHolder.textThang = convertView.findViewById(R.id.textThangNawm);
            viewHolder.textGioDiaDiem = convertView.findViewById(R.id.textViewGioDiaDiem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ThoiGianCuaDiaDiemAdapter.ViewHolder) convertView.getTag();
        }


        LichHienMau lichHienMau = listData.get(position);
        viewHolder.textNgay.setText(lichHienMau.getThoiGian().ThoiGianNgay());
        viewHolder.textThang.setText(lichHienMau.getThoiGian().ThoiGianThang()+"-"+lichHienMau.getThoiGian().ThoiGianNam());
        viewHolder.textGioDiaDiem.setText(lichHienMau.getThoiGian().getGioBatDau()+" - " + lichHienMau.getThoiGian().getGioKetThuc() +
                "\n" + lichHienMau.getDiaDiem().getTenDiaDiem());
        return convertView;
    }
}
