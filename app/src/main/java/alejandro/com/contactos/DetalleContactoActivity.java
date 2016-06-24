package alejandro.com.contactos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import alejandro.com.contactos.pojo.Contacto;

public class DetalleContactoActivity extends AppCompatActivity {


    private static final String TAG = DetalleContactoActivity.class.getName();

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto)  ;

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(Contacto.URL);
        int likes = extras.getInt(Contacto.LIKE);

        Log.i(TAG,url);
        Log.i(TAG,likes+"");



        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.descarga).into(imgFotoDetalle);
    }

    /*
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
    */
}
