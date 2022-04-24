package com.example.mad_n5_t16.model_class;

public class LichHienMau {
    private int id;
    private ThoiGian thoiGian;
    private String ghiChu;

    public LichHienMau(ThoiGian thoiGian, String ghiChu) {
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
    }

    public LichHienMau() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThoiGian getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(ThoiGian thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
