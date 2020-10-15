package algorithm.mhernandez.petagram.fragment;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.adapter.PerfilAdaptador;
import algorithm.mhernandez.petagram.pojo.Perfil;

public interface IPerfilFragment {

    public void generarLinearLayoutGrind();

    public PerfilAdaptador crearAdaptadorPerfil(ArrayList<Perfil> perfils);

    public void inicializarAdaptadorPerfil(PerfilAdaptador adaptador);
}
