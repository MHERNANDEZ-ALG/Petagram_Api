package algorithm.mhernandez.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PrincipalFragment extends Fragment {
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    public PrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_principal, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Anna",R.drawable.anna_gato,10));
        mascotas.add(new Mascota("Aron",R.drawable.aron_perro,15));
        mascotas.add(new Mascota("Dante",R.drawable.dante_perro,21));
        mascotas.add(new Mascota("Droid",R.drawable.droid_gato,33));
        mascotas.add(new Mascota("Jacobs",R.drawable.jacobs_conejo,14));
        mascotas.add(new Mascota("Sasha",R.drawable.sasha_perro,8));
        mascotas.add(new Mascota("Shen",R.drawable.shen_perro,5));
    }
}