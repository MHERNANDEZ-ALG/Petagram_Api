package algorithm.mhernandez.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.db.ContructorMascotas;
import algorithm.mhernandez.petagram.fragment.IPrincipalFragment;
import algorithm.mhernandez.petagram.pojo.Mascota;

public class PrincipalFragmentPresentador implements IPrincipalFragmentPresentador {
    private IPrincipalFragment iPrincipalFragment;
    private Context context;
    private ContructorMascotas contructorMascotas;
    private ArrayList<Mascota> mascotas;
    public PrincipalFragmentPresentador(IPrincipalFragment iPrincipalFragment, Context context) {
        this.iPrincipalFragment = iPrincipalFragment;
        this.context = context;
        obtenerDatosBD();
    }

    @Override
    public void obtenerDatosBD() {
        contructorMascotas = new ContructorMascotas(context);
        mascotas = contructorMascotas.ObtenerDatos();
        mostrarDatosRV();
    }

    @Override
    public void mostrarDatosRV() {
        iPrincipalFragment.inicializarAdaptadorMascota(iPrincipalFragment.crearAdaptadorMascota(mascotas));
        iPrincipalFragment.generarLinearLayoutVertical();
    }
}
