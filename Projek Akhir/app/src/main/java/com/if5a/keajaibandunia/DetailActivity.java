package com.if5a.keajaibandunia;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
public class DetailActivity extends AppCompatActivity {
    private ImageView iv_foto;
    private TextView tv_nama, tv_umur, tv_tentang, tv_ditemukan;
    private Button btn_lokasi;
    private String lokasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv_foto = findViewById(R.id.iv_foto);
        tv_nama = findViewById(R.id.tv_nama);
        tv_ditemukan = findViewById(R.id.tv_ditemukan);
        tv_tentang = findViewById(R.id.tv_tentang);
        btn_lokasi = findViewById(R.id.btn_lokasi);
        tv_umur = findViewById(R.id.tv_umur);

        DataKeajaiban dataKeajaiban = StoreData.dataKeajaiban;

        iv_foto.setImageResource(dataKeajaiban.getFoto());
        tv_nama.setText(dataKeajaiban.getNama());
        tv_tentang.setText(dataKeajaiban.getTentang());
        tv_umur.setText(dataKeajaiban.getUmur());
        tv_ditemukan.setText(dataKeajaiban.getDitemukan());
        // Intent Maps
        btn_lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lokasi = dataKeajaiban.getLokasi();
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasi));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}