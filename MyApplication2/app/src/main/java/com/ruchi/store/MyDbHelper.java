package com.ruchi.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ACER on 01/08/2016.
 */
public class MyDbHelper extends SQLiteOpenHelper{

    private static final String nama_database = "dbstore.db";
    private static final int versi_database = 1;
    private static final String query_buat_tabel = "CREATE TABLE IF NOT EXISTS tabel_pembelian(id_beli INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT)";
    private static final String query_hapus_tabel = "DROP TABLE IF EXISTS query_buat_tabel";

    public MyDbHelper(Context context) {
        super(context, nama_database, null, versi_database);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query_buat_tabel);
        System.out.println("tabel_pembelian sudah dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versi_lama, int versi_baru) {
        database.execSQL(query_hapus_tabel);
        onCreate(database);

    }

    public void tambah_pembelian(String item) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("item", item);
        database.insert("tabel_pembelian", null, values);
        database.close();
    }

    public ArrayList<HashMap<String, String>> tampil_pembelian() {
        SQLiteDatabase database = this.getWritableDatabase();

        // deklarasikan sebuah arraylist yang bisa menampung hashmap
        ArrayList<HashMap<String, String>> arrayListpembelian = new ArrayList<HashMap<String, String>>();

        Cursor cursor = database.rawQuery("SELECT * FROM tabel_pembelian", null);

        // kursor langsung diarkan ke posisi paling awal data pada tabel_pembelian
        if (cursor.moveToFirst()) {
            do {
                // deklarasikan sebuah hashmap, yang bisa menamp
                HashMap<String, String> hashMappembelian = new HashMap<String, String>();

                // masukkan masing-masing field dari tabel_biodata ke dalamhashMapBiodata
                // pastikan id_biodata, nama dan alamat sama persis dengan field yang ada pada tabel_biodata
                hashMappembelian.put("id_beli", cursor.getString(0));
                hashMappembelian.put("item", cursor.getString(1));

                // masukkan hashMapBiodata ke dalam arrayListBiodata
                arrayListpembelian.add(hashMappembelian);

            } while (cursor.moveToNext());
        }

        return arrayListpembelian;
    }
    }
