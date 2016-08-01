package com.ruchi.store;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonadd;
    EditText namaitem;
    ArrayList datapembelian;
    MyDbHelper sqLiteHelper = new MyDbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void topClick(View v){
        //Toast.makeText(MainActivity.this, "Top button clicked", Toast.LENGTH_SHORT).show();
        //setContentView(R.layout.jual_main);
        Log.i("info","The user clicked the top button");
    }
    public void bottomClick(View v){
        //Toast.makeText(MainActivity.this, "bottom button clicked", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.beli_main);
        buttonadd = (Button) findViewById(R.id.add);
        namaitem = (EditText) findViewById(R.id.name);
        Log.i("info","The user clicked the bottom button");
    }
    public void beliClick(View view) {
        sqLiteHelper.tambah_pembelian(namaitem.getText().toString());
        Log.i("info", "The user clicked the beli button");
        datapembelian = sqLiteHelper.tampil_pembelian();
       // Toast.makeText(MainActivity.this, datapembelian + "berhasil dimasukkan", Toast.LENGTH_SHORT).show();
        TextView listbeli = (TextView)findViewById(R.id.text2);
        listbeli.setText(datapembelian.get(datapembelian.size()-1).toString() + " berhasil ditambah");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
