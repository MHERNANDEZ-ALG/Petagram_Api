package algorithm.mhernandez.petagram.fragment;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.adapter.MascotaAdaptador;
import algorithm.mhernandez.petagram.pojo.Mascota;

public interface IPrincipalFragment {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptadorMascota(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorMascota(MascotaAdaptador adaptador);
}
