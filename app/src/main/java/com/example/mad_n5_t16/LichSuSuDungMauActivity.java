package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import com.example.mad_n5_t16.MainActivity;
import com.example.mad_n5_t16.MainActivityEmployee;
import com.example.mad_n5_t16.R;

import org.w3c.dom.Text;

public class LichSuSuDungMauActivity extends AppCompatActivity {

    DatePickerDialog datePickerNgayBatDau, datePickerNgayKetThuc;
    Button btnNgayBatDau, btnNgayKetThuc;
    ImageView markerEmployee, hospitalEmployee, order_historyEmployee;
    private int ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc;
    TextView txtError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_su_dung_mau);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initDatePicker();

        txtError = findViewById(R.id.txtError);
        btnNgayBatDau = findViewById(R.id.btnNgayBatDau);
        btnNgayBatDau.setText(getTodaysDateStart());

        btnNgayKetThuc = findViewById(R.id.btnNgayKetThuc);
        btnNgayKetThuc.setText(getTodaysDateEnd());

        markerEmployee = findViewById(R.id.markerEmployee);
        hospitalEmployee = findViewById(R.id.hospitalEmployee);
        order_historyEmployee = findViewById(R.id.order_historyEmployee);

        order_historyEmployee.setImageResource(R.drawable.order_history_2);

//        markerEmployee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent goMarker = new Intent(LichSuSuDungMauActivity.this, MainActivityEmployee.class);
//                startActivity(goMarker);
//            }
//        });
        hospitalEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHospital = new Intent(LichSuSuDungMauActivity.this, MainActivityEmployee.class);
                startActivity(goHospital);
            }
        });
    }

    private String getTodaysDateStart()
    {
        Calendar cal = Calendar.getInstance();
        namBatDau = cal.get(Calendar.YEAR);
        thangBatDau = cal.get(Calendar.MONTH);
        ngayBatDau = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(ngayBatDau, thangBatDau, namBatDau);
    }
    private String getTodaysDateEnd()
    {
        Calendar cal = Calendar.getInstance();
        namKetThuc = cal.get(Calendar.YEAR);
        thangKetThuc = cal.get(Calendar.MONTH)+1;
        ngayKetThuc= cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(ngayKetThuc, thangKetThuc, namKetThuc);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListenerStart = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                int ngay = day;
                int thang=month+1;
                int nam = year;
                if(validate(ngay, thang, nam, ngayKetThuc, thangKetThuc, namKetThuc)){
                    ngayBatDau = day;
                    thangBatDau=month+1;
                    namBatDau = year;
                    String date = makeDateString(ngayBatDau, thangBatDau, namBatDau);
                    btnNgayBatDau.setText(date);
                    txtError.setVisibility(View.INVISIBLE);
                }
                else{
                    txtError.setVisibility(View.VISIBLE);
                }

            }
        };
        DatePickerDialog.OnDateSetListener dateSetListenerEnd = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                int ngay = day;
                int thang=month+1;
                int nam = year;
                if(validate(ngayBatDau, thangBatDau, namBatDau, ngay, thang, nam)) {
                    ngayKetThuc = day;
                    thangKetThuc=month+1;
                    namKetThuc = year;
                    String date = makeDateString(ngayKetThuc, thangKetThuc, namKetThuc);
                    btnNgayKetThuc.setText(date);
                    txtError.setVisibility(View.INVISIBLE);
                }
                else{
                    txtError.setVisibility(View.VISIBLE);
                }
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerNgayBatDau = new DatePickerDialog(this, style, dateSetListenerStart, year ,month, day);
        datePickerNgayKetThuc = new DatePickerDialog(this, style, dateSetListenerEnd, year ,month-1, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "Tháng 1";
        if(month == 2)
            return "Tháng 2";
        if(month == 3)
            return "Tháng 3";
        if(month == 4)
            return "Tháng 4";
        if(month == 5)
            return "Tháng 5";
        if(month == 6)
            return "Tháng 6";
        if(month == 7)
            return "Tháng 7";
        if(month == 8)
            return "Tháng 8";
        if(month == 9)
            return "Tháng 9";
        if(month == 10)
            return "Tháng 10";
        if(month == 11)
            return "Tháng 11";
        if(month == 12)
            return "Tháng 12";

        //default should never happen
        return "Tháng 1";
    }

    public void datePicker1(View view)
    {
        datePickerNgayBatDau.show();
    }

    public void datePicker2(View view) {
        datePickerNgayKetThuc.show();
    }

    public boolean validate(int ngayBatDau, int thangBatDau, int namBatDau,int ngayKetThuc, int thangKetThuc, int namKetThuc ){
        Date batDau = new Date(namBatDau, thangBatDau-1, ngayBatDau);
        Date ketThuc = new Date(namKetThuc, thangKetThuc-1, ngayKetThuc);

        if(batDau.after(ketThuc)){
            return false;
        }
        else{
            return true;
        }

    }
}