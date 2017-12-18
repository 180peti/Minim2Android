package eetac.minim2app.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class Producto implements Serializable{
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("precio")
    private int precio;
    @SerializedName("ventas")
    private int ventas;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ventas=0;
    }


    //GETTERS Y SETTERS


    public void setVentas(int ventas) {
        this.ventas = this.ventas + ventas;
    }

    public int getPrecio() {
        return precio;
    }

    public int getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return "Producto {nomre="+this.nombre+", precio="+this.precio+", ventas="+this.ventas+"}";
    }
}
