package eetac.minim2app.Service;

import eetac.minim2app.Modelo.ListaPedido;
import eetac.minim2app.Modelo.ListaProducto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public interface Service {

    @GET("/{user}/")
    Call<Boolean> logIn(@Path("user") String user, @Query("pass") String pass);

    @GET("/{user}/realizados")
    Call<ListaPedido> getPedidosRealizados(@Path("user") String user);

    @GET("/productos/precio")
    Call<ListaProducto> getProductos();
}
