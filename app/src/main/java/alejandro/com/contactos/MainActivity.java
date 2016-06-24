package alejandro.com.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import alejandro.com.contactos.pojo.Contacto;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();


    private TextInputEditText nombre;
    private TextInputEditText fecha;
    private TextInputEditText telefono;
    private TextInputEditText correo;
    private TextInputEditText descripcion;

    private AppCompatButton boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (TextInputEditText) findViewById(R.id.nombre);
        fecha = (TextInputEditText) findViewById(R.id.fecha);
        correo = (TextInputEditText) findViewById(R.id.email);
        telefono = (TextInputEditText) findViewById(R.id.telefono);
        descripcion = (TextInputEditText) findViewById(R.id.descripcion);
        boton = (AppCompatButton) findViewById(R.id.boton_confirmar);



        if (getIntent().hasExtra(Contacto.NOMBRE)) {
            Bundle extras = getIntent().getExtras();
            nombre.setText(extras.getString(Contacto.NOMBRE));
            fecha.setText(extras.getString(Contacto.FECHA));
            telefono.setText(extras.getString(Contacto.TELEFONO));
            correo.setText(extras.getString(Contacto.EMAIL));
            descripcion.setText(extras.getString(Contacto.DESCRIPCION));
        }

        datePickerDialog();
        confirmarDatos();

    }

    private void confirmarDatos() {

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);

                intent.putExtra(Contacto.NOMBRE, nombre.getText().toString());
                intent.putExtra(Contacto.FECHA, fecha.getText().toString());
                intent.putExtra(Contacto.TELEFONO, telefono.getText().toString());
                intent.putExtra(Contacto.EMAIL, correo.getText().toString());
                intent.putExtra(Contacto.DESCRIPCION, descripcion.getText().toString());

                startActivity(intent);
                finish();
            }
        });

    }

    private void datePickerDialog() {

        Log.i(TAG, "creando date picker");
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerFragment fragment = new DatePickerFragment();
                fragment.setFecha(fecha);

                fragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        fecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerFragment fragment = new DatePickerFragment();
                    fragment.setFecha(fecha);
                    fragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });

    }


}
