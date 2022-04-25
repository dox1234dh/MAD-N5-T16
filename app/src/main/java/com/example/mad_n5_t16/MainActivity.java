package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.mad_n5_t16.MainActivityEmployee;
import com.example.mad_n5_t16.MainActivityUser;
import com.example.mad_n5_t16.TheAnh.Activity.User.ThongTinCaNhan_Activity;

import com.example.mad_n5_t16.LichSuSuDungMauActivity;
import com.example.mad_n5_t16.MainActivityEmployee;
import com.example.mad_n5_t16.model_class.DatabaseHelper;
import com.example.mad_n5_t16.MainActivityUser;

public class MainActivity extends AppCompatActivity {
    private Button btnCallActivity1;
    private Button btnTTCaNhan;
    private Button btnCallActivity3;
    private Button btnCallActivity4;
    private Button btnCallActivity5;
    private Button btnCallActivity6;
    private Button btnHuongDangKy;
    private Button btnHuongDangNhap;
    private Button btnHuongLichSuHienMau;
    private Button btnMHChinhUser;
    private Button btnMHChinhEmployee;
    private Button btnMHLishSuSuDungMau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnCallActivity1 = (Button) findViewById(R.id.btnCallActivity1);
        btnHuongDangNhap = (Button) findViewById(R.id.btnHuongDangNhap);
        btnHuongDangKy = (Button) findViewById(R.id.btnHuongDangKy);
        btnHuongLichSuHienMau = (Button) findViewById(R.id.btnHuongLichSuHienMau);
        btnMHChinhUser = (Button) findViewById(R.id.btnMHChinhUser);
        btnMHChinhEmployee = (Button) findViewById(R.id.btnMHChinhEmployee);
        btnTTCaNhan = findViewById(R.id.btnThongtinnguoidung);
        btnMHLishSuSuDungMau = (Button) findViewById(R.id.btnMHLichSuSuDungMau);

        btnCallActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongBaoActivity.class);
                startActivity(intent);
            }
        });


        btnMHChinhUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityUser.class);
                startActivity(intent);
            }
        });
        btnMHChinhEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityEmployee.class);
                startActivity(intent);
            }
        });
        btnHuongDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnHuongDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnTTCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongTinCaNhan_Activity.class);
                startActivity(intent);
            }
        });
        btnMHLishSuSuDungMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LichSuSuDungMauActivity.class);
                startActivity(intent);
            }
        });
        Load();
    }
    protected void Load(){

        DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
        //db1.addTK();
//            final List<Student> list1 = db1.getAllStudent();
//            ListView lv1= (ListView)findViewById(R.id.listSinhVien);
//            ArrayAdapter<Student> adapter=new ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1,list1);
        // Student[] adapterStudent = list1.toArray(new Student[list1.size()]);

        // ArrayAdapter<Student> adapter1 = adapterStudent;

//            lv1.setAdapter(adapter);

        //Click listView
//            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                    Toast.makeText(getBaseContext(), "Position :" + arg2 + " - Value = "+list1.get(arg2).getName() ,
//                            Toast.LENGTH_LONG).show();
//                    doOpenChildActivity(list1.get(arg2).getId(),list1.get(arg2).getNumber(), list1.get(arg2).getName(),list1.get(arg2).getEmail());
//
//                }

//            });
//            lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                @Override
//                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                    return false;
//                }
//            });
//
//            registerForContextMenu(lv1);

    }
}
