package eetac.minim2app.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eetac.minim2app.R;
import eetac.minim2app.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAct extends AppCompatActivity {

    public static final String BASE_URL = "http://api.themoviedb.org/";
    private Retrofit retrofit=null;
    EditText user, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.usuario);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setText("");
            }
        });
        pass=findViewById(R.id.password);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setText("");
            }
        });
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos=new Intent(LoginAct.this,Cafeteria.class);
                datos.putExtra("user",user.getText().toString());
                datos.putExtra("pass",pass.getText().toString());
                startActivityForResult(datos,100);
            }
        });


    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        //Si he decidido borrar el historial se hace la nueva array vacia y se va directamente a la pantalla principal
        //Si es que no, no se hace nada
        if((requestCode==100)&&(resultCode== Activity.RESULT_FIRST_USER)){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }
        if((requestCode==100)&&(resultCode== Activity.RESULT_CANCELED)){
            Toast.makeText(getApplicationContext(),"Error al conectar",Toast.LENGTH_LONG).show();
        }


    }

}
