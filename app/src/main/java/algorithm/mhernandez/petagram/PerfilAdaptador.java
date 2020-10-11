package algorithm.mhernandez.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{
    ArrayList <Perfil> perfils;
    Activity activity;
    public PerfilAdaptador(ArrayList<Perfil> perfils, Activity activity){
        this.perfils = perfils;
        this.activity = activity;
    }
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {
        final Perfil perfil = perfils.get(position);

        holder.ivPerfil.setImageResource(perfil.getFoto());
        holder.tvRaiting.setText(String.format("%d", perfil.getRaiting()));
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