package alejandro.com.contactos.restApi.model;

import java.util.List;

import alejandro.com.contactos.pojo.Contacto;

/**
 * Created by Alejandro on 22/06/2016.
 */
public class ContactoResponse {

    List<Contacto> contactos;

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
}
