package com.example.mad_n5_t16.model_class;

public class SuDungMau {
    private int id;
    private DangKyHienMau dangKyHienMau;
    private String ngaySuDung;

    public SuDungMau(DangKyHienMau dangKyHienMau, String ngaySuDung) {
        this.dangKyHienMau = dangKyHienMau;
        this.ngaySuDung = ngaySuDung;
    }

    public SuDungMau() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DangKyHienMau getDangKyHienMau() {
        return dangKyHienMau;
    }

    public void setDangKyHienMau(DangKyHienMau dangKyHienMau) {
        this.dangKyHienMau = dangKyHienMau;
    }

    public String getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(String ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }
}
