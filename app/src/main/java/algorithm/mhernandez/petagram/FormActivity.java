package algorithm.mhernandez.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    String correo = "mhtestscode@gmail.com";
    String pass;

    EditText etMensaje;
    EditText etNombre;
    EditText etCorreo;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        correo = "mhtestscode@gmail.com";
        pass = "mhtc.1991";
        etMensaje = findViewById(R.id.txtMensaje);
        etNombre = findViewById(R.id.txtNombre);
        etCorreo = findViewById(R.id.txtEmail);

        button = findViewById(R.id.btnEnviarCom);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(FormActivity.this,"Comentario Enviado",Toast.LENGTH_LONG).show();
                String correorem = etCorreo.getText().toString();
                String nombreRe = etNombre.getText().toString();
                String contenido = etMensaje.getText().toString();
                new SendMail(correo, pass).execute(new SendMail.Mail(
                        "App_Petagram", correo,
                                "Mensaje de: " + nombreRe + correorem, contenido));
                etCorreo.setText("");
                etNombre.setText("");
                etMensaje.setText("");
            }
        });
    }
}