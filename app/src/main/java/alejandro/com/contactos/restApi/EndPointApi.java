package alejandro.com.contactos.restApi;

import alejandro.com.contactos.restApi.model.ContactoResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alejandro on 22/06/2016.
 */
public interface EndPointApi {

    @GET(ConstantesRestApi.URL_RECENT_MEDIA_USER)
    public Call<ContactoResponse> getRecentMedia();

}
