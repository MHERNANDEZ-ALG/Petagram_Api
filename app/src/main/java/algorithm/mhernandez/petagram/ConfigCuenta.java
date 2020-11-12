package algorithm.mhernandez.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import algorithm.mhernandez.petagram.restApi.model.UsuarioResponse;

public class ConfigCuenta extends AppCompatActivity {

    EditText etCuenta;
    Button btnGuardar;
    private UsuarioResponse usuarioResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_cuenta);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        usuarioResponse = new UsuarioResponse();
        etCuenta = findViewById(R.id.etCuentaConf);
        btnGuardar = findViewById(R.id.btnGuardarC);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etCuenta.getText().toString();
                if(data.equals("@_artattic_")) {
                    Toast.makeText(ConfigCuenta.this, "Cuenta Guardada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ConfigCuenta.this, "Cuenta Erronea", Toast.LENGTH_SHORT).show();
                }
                etCuenta.setText("");
            }
        });
    }
}