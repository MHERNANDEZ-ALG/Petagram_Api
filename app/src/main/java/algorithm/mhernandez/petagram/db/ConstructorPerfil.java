package algorithm.mhernandez.petagram.db;

import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.pojo.Perfil;

public class ConstructorPerfil {
    Context context;

    public ConstructorPerfil(Context context) {
        this.context = context;
    }

    public ArrayList<Perfil> ObtenerDatos(){
        ArrayList <Perfil> perfils = new ArrayList<>();

        perfils.add(new Perfil(R.drawable.aron_perro,221));
        perfils.add(new Perfil(R.drawable.mipet1,214));
        perfils.add(new Perfil(R.drawable.mipet8,115));
        perfils.add(new Perfil(R.drawable.mipet2,150));
        perfils.add(new Perfil(R.drawable.mipet7,125));
        perfils.add(new Perfil(R.drawable.mipet3,125));
        perfils.add(new Perfil(R.drawable.mipet6,126));
        perfils.add(new Perfil(R.drawable.mipet4,124));
        perfils.add(new Perfil(R.drawable.mipet5,111));

        return perfils;
    }
}
