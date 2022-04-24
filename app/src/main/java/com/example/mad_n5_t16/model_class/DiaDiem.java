package com.example.mad_n5_t16.model_class;

import java.util.ArrayList;

public class DiaDiem {
    private int id;
    private String diaDiem;
    private ArrayList<LichHienMau> dsLichHienMau;

    public DiaDiem(String diaDiem, ArrayList<LichHienMau> dsLichHienMau) {
        this.diaDiem = diaDiem;
        this.dsLichHienMau = dsLichHienMau;
    }

    public DiaDiem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public ArrayList<LichHienMau> getDsLichHienMau() {
        return dsLichHienMau;
    }

    public void setDsLichHienMau(ArrayList<LichHienMau> dsLichHienMau) {
        this.dsLichHienMau = dsLichHienMau;
    }
}
