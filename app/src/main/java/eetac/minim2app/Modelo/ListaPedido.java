package eetac.minim2app.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class ListaPedido implements Serializable{
    @SerializedName("lista")
    private List<Pedido> lista;

    public ListaPedido(List<Pedido> lista) {
        this.lista = lista;
    }

    public List<Pedido> getLista() {
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
    }
}
