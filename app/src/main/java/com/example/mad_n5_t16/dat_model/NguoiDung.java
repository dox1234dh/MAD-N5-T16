package com.example.mad_n5_t16.dat_model;

public class NguoiDung {

    private String taiKhoan;
    private String matKhau;
    private  String hoVaTen;

    public NguoiDung() {
    }

    public NguoiDung(String taiKhoan, String matKhau, String hoVaTen) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoVaTen = hoVaTen;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
}
