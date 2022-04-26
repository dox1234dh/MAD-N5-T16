package com.example.mad_n5_t16.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_n5_t16.R;

public class RegisterActivity extends AppCompatActivity {

    EditText ettUsernameregister, etpPasswordregister, etpPasswordregisteragain;
    Button btnRegister, btnRegisterBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validateMes = new String(checkValidRegisterInput(ettUsernameregister, etpPasswordregister, etpPasswordregisteragain));
                if(validateMes.equals("")){
                    String addAccountMes = new String(addNewAccount(ettUsernameregister, etpPasswordregister, etpPasswordregisteragain));

                    if(addAccountMes.equals("")){
                        Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegisterActivity.this, addAccountMes, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(RegisterActivity.this, validateMes, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegisterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private String addNewAccount(EditText ettUsernameregister, EditText etpPasswordregister, EditText etpPasswordregisteragain) {
        // trong method nay kiem tra ten tai khoan ton tai, them tai khoan
        String result = "";
        String txtUsername = ettUsernameregister.getText().toString();
        String txtPassword = etpPasswordregister.getText().toString();
        String txtPasswordagain = etpPasswordregisteragain.getText().toString();

        // 1.lấy danh sách tài khoản lên và lưu vào một List
        // 2. Kiểm tra xem tên tài khoản đã tồn tại hay chưa, nếu tồn tại thì result = "Tên tài khoản đã tồn tại"
        // 3. Nếu tên tài khoản chưa tồn tại thì thực hiện thêm tài khoản.


        return result;
    }

    private String checkValidRegisterInput(EditText ettUsernameregister, EditText etpPasswordregister, EditText etpPasswordregisteragain) {
        // trong method nay kiem tr xau rong, ky tu dac biet
        String result = "";
        String txtUsername = ettUsernameregister.getText().toString();
        String txtPassword = etpPasswordregister.getText().toString();
        String txtPasswordagain = etpPasswordregisteragain.getText().toString();

        if(txtUsername.equals("")||txtPassword.equals("")||txtPasswordagain.equals("")){
            result = "Cần nhập đủ tất cả các trường";
        }else if (!txtPassword.equals(txtPasswordagain)){
            result = "Mật khẩu nhập lại không đúng";
        }else if (txtUsername.split(" ").length > 1 ||
                txtPassword.split(" ").length > 1 ||
                txtPasswordagain.split(" ").length > 1){
            result = "Không nhập khoảng trắng";
        }else if(txtPassword.length() < 8) {
            result = "Mật khẩu cần dài ít nhất 8 ký tự";
        }
        return result;
    }

    private void init() {
        ettUsernameregister = findViewById(R.id.ettUsernameregister);
        etpPasswordregister = findViewById(R.id.etpPasswordregister);
        etpPasswordregisteragain = findViewById(R.id.etpPasswordregisteragain);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegisterBack = findViewById(R.id.btnRegisterBack);
    }
}