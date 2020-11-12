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
        perfils.add(new Perfil(8, R.drawable.insta1));
        perfils.add(new Perfil(8, R.drawable.i2));
        perfils.add(new Perfil(9, R.drawable.i3));
        perfils.add(new Perfil(14, R.drawable.i4));
        perfils.add(new Perfil(15, R.drawable.i5));
        perfils.add(new Perfil(11, R.drawable.i6));
        perfils.add(new Perfil(2, R.drawable.i7));
        perfils.add(new Perfil(2, R.drawable.i8));
        perfils.add(new Perfil(2, R.drawable.i9));
        perfils.add(new Perfil(2, R.drawable.i10));
        perfils.add(new Perfil(2, R.drawable.i11));
        perfils.add(new Perfil(2, R.drawable.i12));
        perfils.add(new Perfil(2, R.drawable.i13));
        perfils.add(new Perfil(2, R.drawable.i14));
        perfils.add(new Perfil(2, R.drawable.i15));

        return perfils;
    }
}
