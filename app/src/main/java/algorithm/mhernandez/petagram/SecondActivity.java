package algorithm.mhernandez.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.adapter.MascotaAdaptador;
import algorithm.mhernandez.petagram.adapter.MascotaFavAdaptador;
import algorithm.mhernandez.petagram.db.ContructorMascotas;
import algorithm.mhernandez.petagram.fragment.IPrincipalFragment;
import algorithm.mhernandez.petagram.pojo.Mascota;
import algorithm.mhernandez.petagram.presentador.IPrincipalFragmentPresentador;
import algorithm.mhernandez.petagram.presentador.ISecondActivityPresentador;
import algorithm.mhernandez.petagram.presentador.PrincipalFragmentPresentador;
import algorithm.mhernandez.petagram.presentador.SecondActivityPresentador;

public class SecondActivity extends AppCompatActivity implements ISecondActivity {
    private RecyclerView listaMascotasFav;
    private ArrayList<Mascota> mascotas;
    //private IPrincipalFragmentPresentador presentador;
    private ISecondActivityPresentador presentator;
    public SecondActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvFavoritos);
        //presentador = new PrincipalFragmentPresentador(this, this);
        presentator = new SecondActivityPresentador(this, this);
        //inicializarListaMascotas();
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    @Override
    public MascotaFavAdaptador crearAdaptadorMascota(ArrayList<Mascota> mascotas) {
        MascotaFavAdaptador adaptador = new MascotaFavAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMascota(MascotaFavAdaptador adaptador) {
        listaMascotasFav.setAdapter(adaptador);
    }

    /*
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();



        mascotas.add(new Mascota("Anna",R.drawable.anna_gato,        10));
        mascotas.add(new Mascota("Aron",R.drawable.aron_perro,       15));
        mascotas.add(new Mascota("Dante",R.drawable.dante_perro,     21));
        mascotas.add(new Mascota("Droid",R.drawable.droid_gato,      33));
        mascotas.add(new Mascota("Jacobs",R.drawable.jacobs_conejo,  14));
    }
     */
}