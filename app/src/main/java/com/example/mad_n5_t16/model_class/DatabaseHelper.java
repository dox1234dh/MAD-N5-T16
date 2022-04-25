package com.example.mad_n5_t16.model_class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
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
                "vaiTro" + "TEXT," +
                "FOREIGN KEY (maNhanVien) REFERENCES tblnhanvien (id)," +
                "FOREIGN KEY (maNguoiHienMau) REFERENCES tblnguoihienmau (id))";
        String sqlQueryNV = "CREATE TABLE " + "tblnhanvien" + " (" +
                ID + " integer primary key, " +
                "chucVu" + "TEXT)";
        String sqlQueryNHM = "CREATE TABLE " + "tblnguoihienmau" + " (" +
                ID + " integer primary key, " +
                "ngaySinh" + " TEXT, " +
                "email" + " TEXT, " +
                "soCCCD" + " TEXT, " +
                "nhomMau" + " TEXT, " +
                "dienthoai TEXT)";
        String sqlQueryDD = "CREATE TABLE " + "tbldiadiem" + " (" +
                ID + " integer primary key, " +
                "tenDiaDiem " + "TEXT)";
        String sqlQueryTG = "CREATE TABLE " + "tblthoigian" + " (" +
                ID + " integer primary key, " +
                "ngay " + "TEXT," +
                "gioBatDau TEXT," +
                "gioKetThuc TEXT)";
        String sqlQuerySDM = "CREATE TABLE " + "tblsudungmau" + " (" +
                ID + "integer primary key," +
                "maDangKyHienMau integer," +
                "ngaySuDung TEXT," +
                "FOREIGN KEY (maDangKyHienMau) REFERENCES tbldangkyhienmau (id))";
        String sqlQueryDKHM = "CREATE TABLE " + "tbldangkyhienmau" + " (" +
                ID + "integer primary key," +
                "maSuDungMau integer," +
                "maNguoiHienMau integer," +
                "luongmau integer," +
                "FOREIGN KEY (maNguoiHienMau) REFERENCES tblnguoihienmau (id)," +
                "FOREIGN KEY (maSuDungMau) REFERENCES tblsudungmau (id))";
        String sqlQueryLHM = "CREATE TABLE " + "tbllichhienmau" + " (" +
                ID + " integer primary key, " +
                "thoiGian " + "TEXT," +
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
    public void addTK(){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("hoTen", "dotv");
        values.put("taiKhoan", "1");
        values.put("matKhau", "1");


        //Neu de null thi khi value bang null thi loi
        db.insert("tbltaikhoan",null,values);
        db.close();
    }
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