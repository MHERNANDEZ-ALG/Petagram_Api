package algorithm.mhernandez.petagram;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList <Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.ivPerfil.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRaiting.setText(String.format("%d", mascota.getRaiting()));
        holder.ibRaitear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tvRaiting.setText(String.format("%d", mascota.getRaiting()+1));
                Toast.makeText(activity,"Like "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPerfil;
        private TextView tvNombre;
        private ImageButton ibRaitear;
        private TextView tvRaiting;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivPerfil = (ImageView) itemView.findViewById(R.id.ivPerfil);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            ibRaitear = (ImageButton) itemView.findViewById(R.id.ibRaitear);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
        }
    }

}
