package alejandro.com.contactos.restApi;

/**
 * Created by Alejandro on 22/06/2016.
 */
public class ConstantesRestApi {


    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN= "3435808795.adc7217.cf4e508eacab445bba989dfb877d0c6f";
    public static final String KEY_ACCESS_TOKEN= "?access_token=";
    public static final String KEY_GET_INFORMATION_USER= "users/self/media/recent/";

    public static final String URL_RECENT_MEDIA_USER= KEY_GET_INFORMATION_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=3435808795.adc7217.cf4e508eacab445bba989dfb877d0c6f


}
