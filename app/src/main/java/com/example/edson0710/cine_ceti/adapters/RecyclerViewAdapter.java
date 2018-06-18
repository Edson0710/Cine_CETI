package com.example.edson0710.cine_ceti.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.edson0710.cine_ceti.model.Peliculas;
import com.example.edson0710.cine_ceti.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Peliculas> mData;
    private RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Peliculas> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.pelicula_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_titulo.setText(mData.get(position).getTitulo());
        holder.tv_duracion.setText(mData.get(position).getDuracion() + " minutos");
        holder.tv_f_estreno.setText(mData.get(position).getF_estreno());
        holder.tv_clasificacion.setText(mData.get(position).getClasificacion());

        //Load image from Internet

        Glide.with(mContext).load(mData.get(position).getImagen()).apply(option).into(holder.iv_imagen);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_titulo;
        TextView tv_duracion;
        TextView tv_f_estreno;
        TextView tv_clasificacion;
        ImageView iv_imagen;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_duracion = itemView.findViewById(R.id.tv_duracion);
            tv_f_estreno = itemView.findViewById(R.id.tv_f_estreno);
            tv_clasificacion = itemView.findViewById(R.id.tv_clasificacion);
            iv_imagen = itemView.findViewById(R.id.iv_imagen);

        }

    }



}
