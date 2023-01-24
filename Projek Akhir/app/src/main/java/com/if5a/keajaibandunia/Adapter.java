package com.if5a.keajaibandunia;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CardViewHolder> {
    private ArrayList<DataKeajaiban> dataKeajaibans;

    public Adapter(ArrayList<DataKeajaiban> dataKeajaibans) {
        this.dataKeajaibans = dataKeajaibans;
    }
    public  interface  OnItemClickCallBack {
        void onItemClicked(DataKeajaiban keajaiban);
    }
    private AdapterGrid.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(AdapterGrid.OnItemClickCallBack callBack){
        this.callBack = callBack;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        DataKeajaiban keajaiban = dataKeajaibans.get(position);
        Picasso.get().load(keajaiban.getFoto()).into(holder.iv_foto);
        holder.tv_nama.setText(keajaiban.getNama());
        holder.tv_tentang.setText(keajaiban.getTentang());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoreData.dataKeajaiban = keajaiban;
                callBack.onItemClicked(dataKeajaibans.get(holder.getAdapterPosition()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataKeajaibans.size();
    }
    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_foto;
        TextView tv_nama, tv_tentang;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.iv_foto);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_tentang = itemView.findViewById(R.id.tv_tentang);


        }
    }
}
