package algorithm.mhernandez.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

            }
        });
    }
}