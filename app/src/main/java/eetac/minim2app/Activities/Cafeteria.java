package eetac.minim2app.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import eetac.minim2app.AdapterView.AdapterViewProductos;
import eetac.minim2app.Modelo.ListaPedido;
import eetac.minim2app.Modelo.ListaProducto;
import eetac.minim2app.Modelo.Producto;
import eetac.minim2app.R;
import eetac.minim2app.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cafeteria extends AppCompatActivity {

    public static final String BASE_URL = "http://api.themoviedb.org/";
    private Retrofit retrofit=null;
    String user, pass;
    private RecyclerView mostrar = null;
    Button pedidos,productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);
        user=getIntent().getExtras().getString("user");
        pass=getIntent().getExtras().getString("pass");
        pedidos=findViewById(R.id.pedido);
        pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPedidos();
            }
        });
        productos=findViewById(R.id.productos);
        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProductos();
            }
        });


    }

    public void getProductos(){
        final ProgressDialog prog=new ProgressDialog(this);
        prog.setIndeterminate(true);
        prog.setMessage("Buscando");
        prog.show();
        if(retrofit==null){
            this.retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Service retro=retrofit.create(Service.class);
        Call<ListaProducto> call=retro.getProductos();
        call.enqueue(new Callback<ListaProducto>() {
            @Override
            public void onResponse(Call<ListaProducto> call, Response<ListaProducto> response) {
                List<Producto> a=response.body().getLista();
                mostrar.setAdapter(new AdapterViewProductos(a,R.layout.lista_productos,getApplicationContext()));
                prog.dismiss();
            }

            @Override
            public void onFailure(Call<ListaProducto> call, Throwable t) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    //SIN ACABAR EL ADAPTERVIEW PARA LOS PEDIDOS
    public void getPedidos(){
        final ProgressDialog prog=new ProgressDialog(this);
        prog.setIndeterminate(true);
        prog.setMessage("Buscando");
        prog.show();
        if(retrofit==null){
            this.retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Service retro=retrofit.create(Service.class);
        Call<ListaPedido> call=retro.getPedidosRealizados(user);
        call.enqueue(new Callback<ListaPedido>() {
            @Override
            public void onResponse(Call<ListaPedido> call, Response<ListaPedido> response) {
                //List<Producto> a=response.body().getLista();
                //mostrar.setAdapter(new AdapterViewProductos(a,R.layout.lista_productos,getApplicationContext()));
                prog.dismiss();
            }

            @Override
            public void onFailure(Call<ListaPedido> call, Throwable t) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    public void connect(){
        final ProgressDialog prog=new ProgressDialog(this);
        prog.setIndeterminate(true);
        prog.setMessage("Buscando");
        prog.show();
        if(retrofit==null){
            this.retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Service retro=retrofit.create(Service.class);
        Call<Boolean> call=retro.logIn(user,pass);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(!response.body()){
                    setResult(RESULT_FIRST_USER);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
