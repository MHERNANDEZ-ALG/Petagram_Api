package algorithm.mhernandez.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;
import javax.mail.internet.MimeMessage;

public class FormActivity extends AppCompatActivity {

    String correo = "mhtestscode@gmail.com";
    String contraseña;
    Session session;

    EditText etMensaje;
    EditText etNombre;
    EditText etCorreo;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        correo = "mhtestscode@gmail.com";
        contraseña = "mhtc.1991";
        etMensaje = (EditText) findViewById(R.id.txtMensaje);
        etNombre = (EditText) findViewById(R.id.txtNombre);
        etCorreo = (EditText) findViewById(R.id.txtEmail);

        button = (Button) findViewById(R.id.btnEnviarCom);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(FormActivity.this,"Comentario Enviado",Toast.LENGTH_LONG).show();
                String correorem = etCorreo.getText().toString();
                String nombreRe = etNombre.getText().toString();
                String contenido = etMensaje.getText().toString();
                new SendMail(correo, contraseña).execute(new SendMail.Mail(
                        "App_Petagram", correo,
                                "Mensaje de: " + nombreRe + correorem, contenido));
                etCorreo.setText("");
                etNombre.setText("");
                etMensaje.setText("");
            }
        });
    }
}