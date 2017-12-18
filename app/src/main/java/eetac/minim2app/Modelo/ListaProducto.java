package eetac.minim2app.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class ListaProducto implements Serializable{

    @SerializedName("lista")
    private List<Producto> lista;

    public ListaProducto(List<Producto> lista) {
        this.lista = lista;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
}
