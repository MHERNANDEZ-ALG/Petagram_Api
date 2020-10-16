package algorithm.mhernandez.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.ISecondActivity;
import algorithm.mhernandez.petagram.db.ContructorMascotas;
import algorithm.mhernandez.petagram.pojo.Mascota;

public class SecondActivityPresentador implements ISecondActivityPresentador{

    private ISecondActivity iSecondActivity;
    private Context context;
    private ContructorMascotas contructorMascotas;
    private ArrayList<Mascota> mascotas;
    public SecondActivityPresentador(ISecondActivity iSecondActivity, Context context) {
        this.iSecondActivity = iSecondActivity;
        this.context = context;
        obtenerDatosBD();
    }

    @Override
    public void obtenerDatosBD() {
        contructorMascotas = new ContructorMascotas(context);
        mascotas = contructorMascotas.ObtenerDatosFav();
        mostrarDatosRV();
    }

    @Override
    public void mostrarDatosRV() {
        iSecondActivity.inicializarAdaptadorMascota(iSecondActivity.crearAdaptadorMascota(mascotas));
        iSecondActivity.generarLinearLayoutVertical();
    }
}
