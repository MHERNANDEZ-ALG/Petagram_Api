package algorithm.mhernandez.petagram;

import android.icu.lang.UCharacter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private RecyclerView listaFotosP;
    ArrayList<Perfil> perfils;
    public PerfilFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotosP = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaFotosP.setLayoutManager(glm);
        inicializarListaFotosP();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(perfils, getActivity());
        listaFotosP.setAdapter(adaptador);
    }

    public void inicializarListaFotosP(){
        perfils = new ArrayList<Perfil>();

        perfils.add(new Perfil(R.drawable.aron_perro,221));
        perfils.add(new Perfil(R.drawable.mipet1,214));
        perfils.add(new Perfil(R.drawable.mipet8,115));
        perfils.add(new Perfil(R.drawable.mipet2,150));
        perfils.add(new Perfil(R.drawable.mipet7,125));
        perfils.add(new Perfil(R.drawable.mipet3,125));
        perfils.add(new Perfil(R.drawable.mipet6,126));
        perfils.add(new Perfil(R.drawable.mipet4,124));
        perfils.add(new Perfil(R.drawable.mipet5,111));
    }
}