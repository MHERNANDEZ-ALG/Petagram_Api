package algorithm.mhernandez.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.pojo.Perfil;
import algorithm.mhernandez.petagram.R;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{
    ArrayList <Perfil> perfils;
    Activity activity;
    public PerfilAdaptador(ArrayList<Perfil> perfils, Activity activity){
        this.perfils = perfils;
        this.activity = activity;
    }
    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final PerfilViewHolder holder, int position) {
        final Perfil perfil = perfils.get(position);
        /*
        Picasso.with(activity)
                .load(perfil.getUrlfoto())
                .placeholder(R.drawable.aron_perro)
                .into(holder.ivPerfil);
         */
        holder.ivPerfil.setImageResource(perfil.getFoto());
        holder.tvRaiting.setText(String.valueOf(perfil.getRaiting()));
    }
    @Override
    public int getItemCount() {
        return perfils.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPerfil;
        private TextView tvRaiting;
        public PerfilViewHolder(View itemView) {
            super(itemView);
            ivPerfil = (ImageView) itemView.findViewById(R.id.ivPerfilP);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaitingP);
        }
    }
}