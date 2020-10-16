package algorithm.mhernandez.petagram.adapter;

import android.app.Activity;
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

import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.db.ContructorMascotas;
import algorithm.mhernandez.petagram.pojo.Mascota;

public class MascotaFavAdaptador extends RecyclerView.Adapter<MascotaFavAdaptador.MascotaFavViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaFavAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public MascotaFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaFavViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaFavViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.ivPerfil.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRaiting.setText(String.valueOf(mascota.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaFavViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPerfil;
        private TextView tvNombre;
        private ImageButton ibRaitear;
        private TextView tvRaiting;
        public MascotaFavViewHolder(View itemView) {
            super(itemView);
            ivPerfil = (ImageView) itemView.findViewById(R.id.ivPerfil);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            ibRaitear = (ImageButton) itemView.findViewById(R.id.ibRaitear);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
        }
    }
}
