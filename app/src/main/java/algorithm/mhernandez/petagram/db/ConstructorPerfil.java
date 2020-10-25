package algorithm.mhernandez.petagram.db;

import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.pojo.Mascota;
import algorithm.mhernandez.petagram.pojo.Perfil;

public class ConstructorPerfil {
    Context context;
    public ConstructorPerfil(Context context) {
        this.context = context;
    }

    public ArrayList<Perfil> ObtenerDatos(){
        ArrayList <Perfil> perfils = new ArrayList<>();
        perfils.add(new Perfil(201, R.drawable.aron_perro));
        perfils.add(new Perfil(213, R.drawable.mipet1));
        perfils.add(new Perfil(154, R.drawable.mipet2));
        perfils.add(new Perfil(152, R.drawable.mipet3));
        perfils.add(new Perfil(142, R.drawable.mipet4));
        perfils.add(new Perfil(144, R.drawable.mipet5));
        perfils.add(new Perfil(135, R.drawable.mipet6));
        perfils.add(new Perfil(102, R.drawable.mipet7));
        perfils.add(new Perfil(201, R.drawable.mipet8));
        return perfils;
    }
}
