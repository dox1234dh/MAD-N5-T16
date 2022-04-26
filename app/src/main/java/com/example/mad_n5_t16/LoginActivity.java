package com.example.mad_n5_t16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_n5_t16.model_class.TaiKhoan;

public class LoginActivity extends AppCompatActivity {

    EditText ettUsername;
    EditText etpPassword;
    Button btnLogin;
    TextView tvRegister;
    TaiKhoan taiKhoan = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ettUsername.getText().toString();
                String passWord = etpPassword.getText().toString();
                if(checkValidateAccount(userName, passWord)){
                    // đăng nhập thành công
                    // kiểm tra xem tài khoản thuộc về nhân viên hay người hiến máu
                    // nếu là người hiến máu thì
                    // tạo một NguoiHienMau và put extra sang cho màn hình chính của người hiến máu
                    // nếu là nhân viên thì
                    // tạo một NhanVien và put extra sang cho màn hình chính của nhân viên
                }else {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean checkValidateAccount(String userName, String passWord) {
        // viết câu truy vấn tìm xem trong csdl có thông tin tài khoản và mật khẩu không
        // taiKhoan = getTaiKhoanByUsernameAndPassword()
        if(taiKhoan!=null){
            return true;
        }
        return false;
    }

    private void init(){
        ettUsername = findViewById(R.id.ettUsername);
        etpPassword = findViewById(R.id.etpPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }


}