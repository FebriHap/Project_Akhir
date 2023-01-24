package com.if5a.keajaibandunia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder> {
    private ArrayList<DataKeajaiban> dataKeajaibans;
    public AdapterGrid(ArrayList<DataKeajaiban> dataKeajaibans) {
        this.dataKeajaibans = dataKeajaibans;
    }
    public  interface  OnItemClickCallBack {
        void onItemClicked(DataKeajaiban keajaiban);
    }
    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack callBack){
        this.callBack = callBack;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        DataKeajaiban keajaiban = dataKeajaibans.get(position);
        Picasso.get().load(keajaiban.getFoto()).into(holder.iv_foto);
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
    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_foto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.iv_foto);
        }
    }
}
