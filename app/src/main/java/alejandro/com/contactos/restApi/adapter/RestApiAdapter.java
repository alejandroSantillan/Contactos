package alejandro.com.contactos.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import alejandro.com.contactos.restApi.ConstantesRestApi;
import alejandro.com.contactos.restApi.EndPointApi;
import alejandro.com.contactos.restApi.deserializador.ContactoDeserializador;
import alejandro.com.contactos.restApi.model.ContactoResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alejandro on 22/06/2016.
 */
public class RestApiAdapter {

    public EndPointApi establecerConexionRestApiInstagram(Gson gson) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(EndPointApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class,new ContactoDeserializador());

        return   gsonBuilder.create();
    }
}
