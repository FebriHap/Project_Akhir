package com.if5a.keajaibandunia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKeajaiban;
    private Button btn_lihat;
    private ArrayList<DataKeajaiban> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKeajaiban = findViewById(R.id.rv_Keajaiaban);
        rvKeajaiban.setHasFixedSize(true);

        arrayList.addAll(ListKeajaiban.getListKeajaiban());
        tampilData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.i_card:
                tampilData();
                break;
            case R.id.i_grid:
                tampilDataGrid();
                break;
            case R.id.i_info:
                Intent pindah = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(pindah);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void tampilData(){
        rvKeajaiban.setLayoutManager(new LinearLayoutManager(this));
        Adapter tampil = new Adapter(arrayList);
        rvKeajaiban.setAdapter(tampil);

        tampil.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(DataKeajaiban keajaiban) {
                StoreData.dataKeajaiban = keajaiban;
                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(pindah);
            }
        });

    }
    private void tampilDataGrid(){
        rvKeajaiban.setLayoutManager(new LinearLayoutManager(this));
        AdapterGrid tampilGrid = new AdapterGrid(arrayList);
        rvKeajaiban.setAdapter(tampilGrid);

        tampilGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(DataKeajaiban keajaiban) {
                Toast.makeText(MainActivity.this, "Nama Keajaiban:" + keajaiban.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void tampilDataInfo(){
        rvKeajaiban.setLayoutManager(new LinearLayoutManager(this));
    }

}