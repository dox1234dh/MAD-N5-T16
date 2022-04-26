package com.example.mad_n5_t16.model_class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.mad_n5_t16.Model.History;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public final class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mad";
    private static final String ID = "id";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("DB Manager", "DB Manager");

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlQueryTK = "CREATE TABLE " + "tbltaikhoan" + " (" +
                ID + " integer primary key, " +
                "taiKhoan" + " TEXT, " +
                "matKhau" + " TEXT, " +
                "maNhanVien integer," +
                "maNguoiHienMau integer," +
                "hoTen" + " TEXT, " +
                "vaiTro" + " TEXT," +
                "FOREIGN KEY (maNhanVien) REFERENCES tblnhanvien (id)," +
                "FOREIGN KEY (maNguoiHienMau) REFERENCES tblnguoihienmau (id))";
        String sqlQueryNV = "CREATE TABLE " + "tblnhanvien" + " (" +
                ID + " integer primary key, " +
                "chucVu" + " TEXT)";
        String sqlQueryNHM = "CREATE TABLE " + "tblnguoihienmau" + " (" +
                ID + " integer primary key, " +
                "ngaySinh" + " TEXT, " +
                "email" + " TEXT, " +
                "soCCCD" + " TEXT, " +
                "nhomMau" + " TEXT, " +
                "dienThoai TEXT)";
        String sqlQueryDD = "CREATE TABLE " + "tbldiadiem" + " (" +
                ID + " integer primary key, " +
                "tenDiaDiem " + "TEXT)";
        String sqlQueryTG = "CREATE TABLE " + "tblthoigian" + " (" +
                ID + " integer primary key, " +
                "ngay " + "TEXT," +
                "gioBatDau TEXT," +
                "gioKetThuc TEXT)";
        String sqlQuerySDM = "CREATE TABLE " + "tblsudungmau" + " (" +
                ID + " integer primary key," +
                "maDangKyHienMau integer," +
                "ngaySuDung TEXT," +
                "FOREIGN KEY (maDangKyHienMau) REFERENCES tbldangkyhienmau (id))";
        String sqlQueryDKHM = "CREATE TABLE " + "tbldangkyhienmau" + " (" +
                ID + " integer primary key," +
                "maNguoiHienMau integer," +
                "luongMau integer," +
                "FOREIGN KEY (maNguoiHienMau) REFERENCES tblnguoihienmau (id))";
        String sqlQueryLHM = "CREATE TABLE " + "tbllichhienmau" + " (" +
                ID + " integer primary key, " +
                "ghiChu TEXT, " +
                "maDangKyHienMau integer," +
                "maThoiGian integer," +
                "maDiaDiem integer," +
                "FOREIGN KEY (maDangKyHienMau) REFERENCES tbldangkyhienmau (id)," +
                "FOREIGN KEY (maThoiGian) REFERENCES tblthoigian (id)," +
                "FOREIGN KEY (maDiaDiem) REFERENCES tbldiadiem (id))";

        db.execSQL(sqlQueryTG);
        db.execSQL(sqlQueryDD);
        db.execSQL(sqlQueryNV);
        db.execSQL(sqlQueryNHM);
        db.execSQL(sqlQueryLHM);
        db.execSQL(sqlQueryDKHM);
        db.execSQL(sqlQueryTK);
        db.execSQL(sqlQuerySDM);
        Toast.makeText(context, "Create Database successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tblthoigian");
        db.execSQL("DROP TABLE IF EXISTS tbldiadiem");
        db.execSQL("DROP TABLE IF EXISTS tblnhanvien");
        db.execSQL("DROP TABLE IF EXISTS tblnguoihienmau");
        db.execSQL("DROP TABLE IF EXISTS tbllichhienmau");
        db.execSQL("DROP TABLE IF EXISTS tbldangkyhienmau");
        db.execSQL("DROP TABLE IF EXISTS tbltaikhoan");
        db.execSQL("DROP TABLE IF EXISTS tblsudungmau");

        onCreate(db);
//        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();
    }

    public void addTK() {

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM tblnguoihienmau";
        Cursor cursor = db.rawQuery(query, null);
        int t = cursor.getCount();


        //Neu de null thi khi value bang null thi loi
        db.close();
    }

    public NguoiHienMau dat_getNguoiHienMau(TaiKhoan taiKhoan) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "SELECT * FROM tblnguoihienmau WHERE id=?";
        String query = "SELECT tblnguoihienmau.id, tblnguoihienmau.ngaySinh, tblnguoihienmau.email, " +
                "tblnguoihienmau.soCCCD, tblnguoihienmau.nhomMau, tblnguoihienmau.dienThoai, tbltaikhoan.hoTen, tbltaikhoan.vaiTro " +
                "FROM tblnguoihienmau inner join " +
                "tbltaikhoan on tbltaikhoan.maNguoiHienMau = tblnguoihienmau.id " +
                "WHERE tblnguoihienmau.id=?";
        String[] selectionArgs = {String.valueOf(taiKhoan.getId())};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        NguoiHienMau temp = new NguoiHienMau();
//        temp.setHoTen(taiKhoan.getHoTen());
//        temp.setVaiTro(taiKhoan.getVaiTro());
        if (cursor.moveToFirst()) {
            do {
                temp.setId(cursor.getInt(0));
                temp.setNgaySinh(cursor.getString(1));
                temp.setEmail(cursor.getString(2));
                temp.setSoCCCD(cursor.getString(3));
                temp.setNhomMau(cursor.getString(4));
                temp.setDienThoai(cursor.getString(5));
                //fix cung
                temp.setHoTen(cursor.getString(6));
                temp.setVaiTro(cursor.getString(7));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return temp;
    }

    public int dat_getSoLanHienMau(int maNguoiHienMau) {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbldangkyhienmau WHERE maNguoiHienMau =? AND luongMau>0";
        String[] selectionArgs = {String.valueOf(maNguoiHienMau)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        result = cursor.getCount();

        return result;
    }

    public void themDangKyHienMau(DangKyHienMau dangKyHienMau) {
        NguoiHienMau tempNHM = new NguoiHienMau("taiKhoan1", "1", "Trịnh Tiến Đạt", "1",
                "23122000", "abc@gmail.com", "123456789", " ", "0368257596");
        ThoiGian tempTG = new ThoiGian("25042022", "07:00", "11h:00");
        DiaDiem tempDD = new DiaDiem("Viện Huyết học và truyền máu trung ương");
        LichHienMau tempLHM = new LichHienMau(tempTG, " ", tempDD);
        DangKyHienMau temp = new DangKyHienMau(tempLHM, tempNHM, 350);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("");

    }

    public ArrayList<DangKyHienMau> dat_layDSDangKyHienMau() {
        ArrayList<DangKyHienMau> result = new ArrayList<DangKyHienMau>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT tbldiadiem.tenDiaDiem, tbltaikhoan.hoTen, tblnguoihienmau.dienThoai " +
                "FROM tblthoigian inner join tbllichhienmau " +
                "on tblthoigian.id=tbllichhienmau.maThoiGian " +
                "inner join tbldiadiem on tbllichhienmau.maDiaDiem = tbldiadiem.id " +
                "inner join tbldangkyhienmau on tbllichhienmau.maDangKyHienMau= tbldangkyhienmau.id " +
                "inner join tblnguoihienmau on tbldangkyhienmau.maNguoiHienMau = tblnguoihienmau.id " +
                "inner join tbltaikhoan on tblnguoihienmau.id = tbltaikhoan.maNguoiHienMau " +
                "WHERE tblthoigian.ngay=?";
        Calendar cal = Calendar.getInstance();
        int nam = cal.get(Calendar.YEAR);
        int thang = cal.get(Calendar.MONTH) + 1;
        int ngay = cal.get(Calendar.DAY_OF_MONTH);
        String[] selectionArgs = {dat_makeDateString(ngay, thang, nam)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                DiaDiem tempDiaDiem = new DiaDiem();
                tempDiaDiem.setTenDiaDiem(cursor.getString(0));
                LichHienMau tempLichHienMau = new LichHienMau();
                tempLichHienMau.setDiaDiem(tempDiaDiem);
                NguoiHienMau tempNguoiHienMau = new NguoiHienMau();
                tempNguoiHienMau.setHoTen(cursor.getString(1));
                tempNguoiHienMau.setDienThoai(cursor.getString(2));
                DangKyHienMau tempDangKyHienMau = new DangKyHienMau();
                tempDangKyHienMau.setLichHienMau(tempLichHienMau);
                tempDangKyHienMau.setNguoiHienMau(tempNguoiHienMau);
                result.add(tempDangKyHienMau);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public int dat_laySoLuongDangKyHienMau() {
        int result=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT tbldiadiem.tenDiaDiem, tbltaikhoan.hoTen FROM tblthoigian inner join tbllichhienmau " +
                "on tblthoigian.id=tbllichhienmau.maThoiGian " +
                "inner join tbldiadiem on tbllichhienmau.maDiaDiem = tbldiadiem.id " +
                "inner join tbldangkyhienmau on tbllichhienmau.maDangKyHienMau= tbldangkyhienmau.id " +
                "inner join tblnguoihienmau on tbldangkyhienmau.maNguoiHienMau = tblnguoihienmau.id " +
                "inner join tbltaikhoan on tblnguoihienmau.id = tbltaikhoan.maNguoiHienMau " +
                "WHERE tblthoigian.ngay=?";
        Calendar cal = Calendar.getInstance();
        int nam = cal.get(Calendar.YEAR);
        int thang = cal.get(Calendar.MONTH) + 1;
        int ngay = cal.get(Calendar.DAY_OF_MONTH);
        String[] selectionArgs = {dat_makeDateString(ngay, thang, nam)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        result= cursor.getCount();
        return result;
    }

    public int dat_laySoLuongMauConLaiTheoNhomMau(String nhomMau) {
        return dat_laySoLuongMauDaHienTheoNhomMau(nhomMau) - dat_laySoLuongMauDaSuDungTheoNhomMau(nhomMau);
    }

    public int dat_laySoLuongMauDaHienTheoNhomMau(String nhomMau) {
        SQLiteDatabase db = this.getReadableDatabase();
        int result = 0;
        String query = "SELECT tbldangkyhienmau.luongMau FROM tbldangkyhienmau " +
                "inner join tblnguoihienmau on tbldangkyhienmau.maNguoiHienMau = tblNguoiHienMau.id " +
                "WHERE tblnguoihienmau.nhomMau =?";
        String[] selectionArgs = {nhomMau};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                result = result + cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public int dat_laySoLuongMauDaSuDungTheoNhomMau(String nhomMau) {
        SQLiteDatabase db = this.getReadableDatabase();
        int result = 0;
        String query = "SELECT tbldangkyhienmau.luongMau FROM tbldangkyhienmau " +
                "inner join tblsudungmau on tblsudungmau.maDangKyHienMau = tbldangkyhienmau.id " +
                "inner join tblnguoihienmau on tbldangkyhienmau.maNguoiHienMau = tblNguoiHienMau.id " +
                "WHERE tblnguoihienmau.nhomMau =?";
        String[] selectionArgs = {nhomMau};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                result = result + cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return result;
    }


    public String dat_makeDateString(int day, int month, int year) {
        return String.valueOf(year) + "/" + dat_getMonthFormat(month) + "/" +String.valueOf(day) ;
    }

    private String dat_getMonthFormat(int month) {
        if (month == 1)
            return "01";
        if (month == 2)
            return "02";
        if (month == 3)
            return "03";
        if (month == 4)
            return "04";
        if (month == 5)
            return "05";
        if (month == 6)
            return "06";
        if (month == 7)
            return "07";
        if (month == 8)
            return "08";
        if (month == 9)
            return "09";
        if (month == 10)
            return "010";
        if (month == 11)
            return "11";
        if (month == 12)
            return "12";

        //default should never happen
        return "Tháng 1";
    }

    public TaiKhoan nam_getTaiKhoanByUserNameAndPassWord(String userName, String passWord) {
        TaiKhoan taiKhoan = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbltaikhoan " +
                "WHERE tbltaikhoan.taiKhoan =? AND tbltaikhoan.matKhau =?";
        String[] selectionArgs = {userName, passWord};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            taiKhoan = new TaiKhoan();
            taiKhoan.setId(cursor.getInt(0));
            taiKhoan.setTaiKhoan(cursor.getString(1));
            taiKhoan.setMatKhau(cursor.getString(2));
            taiKhoan.setVaiTro(cursor.getString(6));
        }
        return taiKhoan;
    }

    public boolean nam_checkTaiKhoanByUsername(String username){
        boolean result = true;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbltaikhoan " +
                "WHERE tbltaikhoan.taiKhoan =?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            result = false;
        }
        return result;
    }

    public boolean nam_checkNguoiHienMauByCCCD(String CCCD) {
        boolean result = true;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tblnguoihienmau " +
                "WHERE tblnguoihienmau.soCCCD =?";
        String[] selectionArgs = {CCCD};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            result = false;
        }
        return result;
    }

    public NguoiHienMau nam_getNguoiHienMauByCCCD(String CCCD) {
        NguoiHienMau nhm = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tblnguoihienmau " +
                "WHERE tblnguoihienmau.soCCCD =?";
        String[] selectionArgs = {CCCD};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            nhm = new NguoiHienMau();
            nhm.setId(cursor.getInt(0));
            nhm.setSoCCCD(cursor.getString(3));
        }
        return nhm;
    }


    public  void nam_addNguoiHienMau(NguoiHienMau nhm) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tblnguoihienmau (ngaySinh, email, soCCCD, nhomMau, dienThoai) VALUES " +
                "(?, ?, ?, ?, ?)";
        String[] selectionArgs = {null, null, nhm.getSoCCCD(), null, null};
        db.execSQL(query, selectionArgs);
    }

    public void nam_addTaiKhoan(TaiKhoan taiKhoan, int idNguoiHienMau) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tbltaikhoan (taiKhoan, matKhau, maNguoiHienMau, vaiTro) VALUES " +
                "(?, ?, ?, ?)";
        String[] selectionArgs = {taiKhoan.getTaiKhoan(), taiKhoan.getMatKhau(),
                                idNguoiHienMau+"", taiKhoan.getVaiTro()};
        db.execSQL(query, selectionArgs);
    }

    public ArrayList<History> nam_getLichSuHienMauByIdNguoiHienMau(int idNguoiHienMau){
        ArrayList<History> listHistory = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT tbldangkyhienmau.luongMau, tbldiadiem.tenDiaDiem, tblthoigian.ngay  FROM tbldangkyhienmau " +
                "inner join tbllichhienmau on tbldangkyhienmau.id = tbllichhienmau.maDangKyHienMau " +
                "inner join tbldiadiem on tbllichhienmau.maDiaDiem = tbldiadiem.id " +
                "inner join tblthoigian on tbllichhienmau.maThoiGian = tblthoigian.id " +
                "WHERE tbldangkyhienmau.luongMau > 0 AND tbldangkyhienmau.maNguoiHienMau = ?";
        String[] selectionArgs = {String.valueOf(idNguoiHienMau)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        int i = 1;
        while (cursor.moveToNext()) {
            History h = new History();
            h.setNumber(i);
            h.setAmount(cursor.getInt(0));
            h.setDonationDate(cursor.getString(2));
            h.setLocation(cursor.getString(1));
            System.out.println(h.getLocation());
            i++;
            listHistory.add(h);
        }

        return listHistory;
    }

//    public NguoiHienMau getNguoiHienMau(NguoiHienMau nguoiHienMau){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query("tblnguoihienmau", new String[] { "id",
//                        "ngaySinh","email","soCCCD", "nhomMau", "dienthoai" }, ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        Student student = new Student(cursor.getString(1),cursor.getString(2),cursor.getString(3));
//        cursor.close();
//        db.close();
//        return student;
//    }

}


//
//    public Student getSdtudentById(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
//                        NAME, EMAIL,NUMBER }, ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        Student student = new Student(cursor.getString(1),cursor.getString(2),cursor.getString(3));
//        cursor.close();
//        db.close();
//        return student;
//    }
//
//    public int Update(Student student) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(NAME, student.getName());
//        values.put(NUMBER, student.getNumber());
//        values.put(EMAIL, student.getEmail());
//
//
//        return db.update(TABLE_NAME, values, ID + "=?", new String[]{String.valueOf(student.getId())});
//    }
//
//    public int Delete(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put(NAME, student.getName());
//        values.put(NUMBER, student.getNumber());
//        values.put(EMAIL, student.getEmail());
//
//
//        return db.delete(TABLE_NAME,  ID + "=?", new String[]{String.valueOf(student.getId())});
//    }
//
//    public List<Student> getAllStudent() {
//
//        List<Student> listStudent = new ArrayList<Student>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Student student = new Student();
//                student.setId(cursor.getInt(0));
//                student.setName(cursor.getString(1));
//                student.setEmail(cursor.getString(2));
//                student.setNumber(cursor.getString(3));
//                listStudent.add(student);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return listStudent;
//    }
//
//    public int getStudentsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }