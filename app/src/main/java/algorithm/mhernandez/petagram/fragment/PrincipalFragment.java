package algorithm.mhernandez.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.pojo.Mascota;
import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.adapter.MascotaAdaptador;
import algorithm.mhernandez.petagram.presentador.IPrincipalFragmentPresentador;
import algorithm.mhernandez.petagram.presentador.PrincipalFragmentPresentador;

public class PrincipalFragment extends Fragment implements IPrincipalFragment {
    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;
    private IPrincipalFragmentPresentador presentador;
    public PrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_principal, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presentador = new PrincipalFragmentPresentador(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptadorMascota(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMascota(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}