package com.example.mad_n5_t16.TheAnh.Activity.User;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_n5_t16.Public.model_class.DatabaseHelper;
import com.example.mad_n5_t16.Public.model_class.NguoiHienMau;
import com.example.mad_n5_t16.R;

public class ChinhSuaThongTinCaNhan_Activity extends AppCompatActivity {
    NguoiHienMau nguoiHienMau;
    EditText txtName, txtDateOfBirth, txtEmail, txtSDT, txtCCCD;
    ImageView btnOkEdit;
    Button btnLuuDangKy;
    DatabaseHelper databaseHelper;
    TextView txtNameTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_mh_thongtincanhan2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Anh xa
        txtNameTitle = findViewById(R.id.textTitle);
        txtNameTitle.setText("Thông tin cá nhân");
        nguoiHienMau = (NguoiHienMau) getIntent().getSerializableExtra("data");
        txtName = findViewById(R.id.textFixName);
        txtDateOfBirth = findViewById(R.id.textFixBirth);
        txtEmail = findViewById(R.id.textFixEmail);
        txtSDT = findViewById(R.id.textFixSDT);
        txtCCCD = findViewById(R.id.textFixCCCD);
        btnOkEdit=findViewById(R.id.imageEditOfFix);
        btnLuuDangKy = findViewById(R.id.btnLuuThongTinOfFix);
        databaseHelper = new DatabaseHelper(this);
        fillData(nguoiHienMau);
        canEdit(false);
        btnLuuDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChangedData();
                databaseHelper.suaThongTinNguoiHienMau(nguoiHienMau);
                Toast.makeText(ChinhSuaThongTinCaNhan_Activity.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnOkEdit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                canEdit(true);
                txtName.setBackgroundColor(getColor(R.color.white));
            }
        });
    }
    private  void fillData(NguoiHienMau nguoiHienMau){
        txtName.setText(nguoiHienMau.getHoTen());
        txtDateOfBirth.setText(nguoiHienMau.getNgaySinh());
        txtEmail.setText(nguoiHienMau.getEmail());
        txtSDT.setText(nguoiHienMau.getDienThoai());
        txtCCCD.setText(nguoiHienMau.getSoCCCD());
    }

    private void getChangedData(){
        nguoiHienMau.setHoTen(txtName.getText().toString());
        nguoiHienMau.setNgaySinh(txtDateOfBirth.getText().toString());
        nguoiHienMau.setEmail(txtEmail.getText().toString());
        nguoiHienMau.setSoCCCD(txtCCCD.getText().toString());
        nguoiHienMau.setDienThoai(txtSDT.getText().toString());
    }
    public void canEdit(boolean ok){
        txtName.setEnabled(ok);
        txtDateOfBirth.setEnabled(ok);
        txtEmail.setEnabled(ok);
        txtSDT.setEnabled(ok);
        txtCCCD.setEnabled(ok);
    }

}