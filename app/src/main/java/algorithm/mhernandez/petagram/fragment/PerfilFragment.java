package algorithm.mhernandez.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.pojo.Perfil;
import algorithm.mhernandez.petagram.adapter.PerfilAdaptador;
import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.presentador.IPerfilFragmentPresentador;
import algorithm.mhernandez.petagram.presentador.PerfilFragmentPresentador;

public class PerfilFragment extends Fragment implements IPerfilFragment {
    private RecyclerView listaFotosP;
    private ArrayList<Perfil> perfils;
    private IPerfilFragmentPresentador presentador;
    public PerfilFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaFotosP = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        presentador = new PerfilFragmentPresentador(this, getContext());
        return v;
    }
    
    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaFotosP.setLayoutManager(glm);
    }

    @Override
    public PerfilAdaptador crearAdaptadorPerfil(ArrayList<Perfil> perfils) {
        PerfilAdaptador adaptador = new PerfilAdaptador(perfils, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorPerfil(PerfilAdaptador adaptador) {
        listaFotosP.setAdapter(adaptador);
    }
}