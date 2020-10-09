package algorithm.mhernandez.petagram;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaMascotas;
    ArrayList<Mascota>  mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_favorite:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Intent intentc = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intentc);
                return true;
            case R.id.action_about:
                Intent intenta = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intenta);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}