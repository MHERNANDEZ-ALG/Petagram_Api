package algorithm.mhernandez.petagram;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.adapter.MascotaAdaptador;
import algorithm.mhernandez.petagram.adapter.MascotaFavAdaptador;
import algorithm.mhernandez.petagram.pojo.Mascota;

public interface ISecondActivity {
    public void generarLinearLayoutVertical();

    public MascotaFavAdaptador crearAdaptadorMascota(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorMascota(MascotaFavAdaptador adaptador);
}
