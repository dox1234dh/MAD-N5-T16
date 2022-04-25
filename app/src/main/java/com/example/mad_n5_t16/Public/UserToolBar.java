package com.example.mad_n5_t16.Public;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mad_n5_t16.MainActivityUser;
import com.example.mad_n5_t16.R;
import com.example.mad_n5_t16.TheAnh.Activity.User.ChinhSuaThongTinCaNhan_Activity;
import com.example.mad_n5_t16.TheAnh.Activity.User.DiaDiem_Activity;
import com.example.mad_n5_t16.TheAnh.Activity.User.ThongTinCaNhan_Activity;

public class UserToolBar {
    Context context;
    int idLayout;
    ImageView btnHome, btnLocation, btnRegister, btnHistory,btnInfor;

    public UserToolBar(Context context,int idLayout, ImageView btnHome, ImageView btnLocation, ImageView btnRegister, ImageView btnHistory, ImageView btnInfor) {
        this.context = context;
        this.btnHome = btnHome;
        this.idLayout = idLayout;
        this.btnLocation = btnLocation;
        this.btnRegister = btnRegister;
        this.btnHistory = btnHistory;
        this.btnInfor = btnInfor;
        switch (idLayout){
            case R.layout.activity_mh_thongtincanhan:
                btnInfor.setImageResource(R.drawable.guest_male_2);
                break;
            case R.layout.activity_mh_diadiemhienmau:
                btnLocation.setImageResource(R.drawable.marker_2);
                break;
            case R.layout.activity_blood_donation_history:
                btnHistory.setImageResource(R.drawable.order_history_2);
                break;
            case R.layout.activity_main_user:
                btnHome.setImageResource(R.drawable.home_2);
                break;
            case R.layout.activiti_mh_thongtincanhan2:
                btnRegister.setImageResource(R.drawable.heart_plus_2);
                break;
        }
        this.btnInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "ttcn", Toast.LENGTH_SHORT).show();
                if(idLayout != R.layout.activity_mh_thongtincanhan){
                    Intent intent = new Intent(context, ThongTinCaNhan_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    context.startActivity(intent);
                    ThongTinCaNhan_Activity.activity.finish();
                }
            }
        });
        this.btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idLayout != R.layout.activity_mh_thongtincanhan){
                    Intent intent = new Intent(context, ThongTinCaNhan_Activity.class);
                    context.startActivity(intent);
                }
                Toast.makeText(context, "lichsu", Toast.LENGTH_SHORT).show();
            }
        });
        this.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idLayout != R.layout.activity_main_user){
                    Intent intent = new Intent(context, MainActivityUser.class);
                    context.startActivity(intent);
                }
                Toast.makeText(context, "home", Toast.LENGTH_SHORT).show();
            }
        });
        this.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idLayout != R.layout.activity_mh_diadiemhienmau){
                    Intent intent = new Intent(context, DiaDiem_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    context.startActivity(intent);
                }
                Toast.makeText(context, "diadiem", Toast.LENGTH_SHORT).show();
            }
        });
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idLayout != R.layout.activity_mh_thongtincanhan){
                    Intent intent = new Intent(context, ThongTinCaNhan_Activity.class);
                    context.startActivity(intent);
                }
                Toast.makeText(context, "dangky", Toast.LENGTH_SHORT).show();
            }
        });
    }
    

}
