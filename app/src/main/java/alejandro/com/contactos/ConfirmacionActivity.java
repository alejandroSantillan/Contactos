package alejandro.com.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import alejandro.com.contactos.pojo.Contacto;

public class ConfirmacionActivity extends AppCompatActivity {

    private TextView nombre;
    private TextView fecha;
    private TextView telefono;
    private TextView email;
    private TextView descripcion;

    private AppCompatButton boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        nombre = (TextView) findViewById(R.id.nombre);
        fecha = (TextView) findViewById(R.id.fecha);
        telefono = (TextView) findViewById(R.id.telefono);
        email = (TextView) findViewById(R.id.email);
        descripcion = (TextView) findViewById(R.id.descripcion);

        boton = (AppCompatButton) findViewById(R.id.editar_boton);

        Bundle extras = getIntent().getExtras();

        nombre.setText(extras.getString(Contacto.NOMBRE));
        fecha.setText(extras.getString(Contacto.FECHA));
        telefono.setText(extras.getString(Contacto.TELEFONO));
        email.setText(extras.getString(Contacto.EMAIL));
        descripcion.setText(extras.getString(Contacto.DESCRIPCION));


        editarDatos();

    }

    private void editarDatos() {

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmacionActivity.this,MainActivity.class);

                intent.putExtra(Contacto.NOMBRE,nombre.getText().toString());
                intent.putExtra(Contacto.FECHA,fecha.getText().toString());
                intent.putExtra(Contacto.TELEFONO,telefono.getText().toString());
                intent.putExtra(Contacto.EMAIL,email.getText().toString());
                intent.putExtra(Contacto.DESCRIPCION,descripcion.getText().toString());

                startActivity(intent);
                finish();
            }
        });


    }
}
