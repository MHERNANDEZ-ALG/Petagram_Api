package algorithm.mhernandez.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.db.ConstructorPerfil;
import algorithm.mhernandez.petagram.fragment.IPerfilFragment;
import algorithm.mhernandez.petagram.pojo.Perfil;

public class PerfilFragmentPresentador implements IPerfilFragmentPresentador{
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<Perfil> perfils;

    public PerfilFragmentPresentador(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerDatosBD();
    }

    @Override
    public void obtenerDatosBD() {
        constructorPerfil = new ConstructorPerfil(context);
        perfils = constructorPerfil.ObtenerDatos();
        mostrarDatosRV();
    }

    @Override
    public void mostrarDatosRV() {
        iPerfilFragment.inicializarAdaptadorPerfil(iPerfilFragment.crearAdaptadorPerfil(perfils));
        iPerfilFragment.generarLinearLayoutGrind();
    }
}
