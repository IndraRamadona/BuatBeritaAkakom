package com.gmail.indraramadhona12.buatberitaakakom;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<DataBerita> data;

    AdapterBerita(Context context, List<DataBerita> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_berita, parent,false);
        MyHolder holder;
        holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        DataBerita current=data.get(position);
        myHolder.textJudul.setText(current.judulBerita);
        myHolder.textTanggal.setText(current.tglPosting);
        myHolder.textBerita.setText(current.isiBerita);

        Glide.with(context)
                .load("https://belajar-unggah.000webhostapp.com/test/images/" + current.gambarBerita)
                .apply(new RequestOptions().placeholder(R.drawable.lantip).error(R.drawable.lantip))
                .into(myHolder.ivBerita);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textJudul;
        ImageView ivBerita;
        TextView textTanggal;
        TextView textBerita;

        MyHolder(View itemView) {
            super(itemView);
            textJudul= itemView.findViewById(R.id.judul);
            ivBerita= itemView.findViewById(R.id.imageView2);
            textTanggal = itemView.findViewById(R.id.tanggal);
            textBerita = itemView.findViewById(R.id.isi);
        }
    }
}
