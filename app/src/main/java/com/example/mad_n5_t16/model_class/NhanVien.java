package com.example.mad_n5_t16.model_class;

public class NhanVien extends TaiKhoan{
    private String chucVu;

    public NhanVien(String taiKhoan, String matKhau, String hoTen, String vaiTro, String chucVu) {
        super(taiKhoan, matKhau, hoTen, vaiTro);
        this.chucVu = chucVu;
    }

    public NhanVien(String taiKhoan, String matKhau, String hoTen, String vaiTro) {
        super(taiKhoan, matKhau, hoTen, vaiTro);
    }

    public NhanVien(String chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
