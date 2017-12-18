package eetac.minim2app.AdapterView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import eetac.minim2app.Modelo.Producto;
import eetac.minim2app.R;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class AdapterViewProductos extends RecyclerView.Adapter<AdapterViewProductos.ProductosHolder>{
    private List<Producto> productos;
    private int rowLayout;
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";
    private Context context;

    public AdapterViewProductos(List<Producto> productos, int rowLayout, Context context) {
        this.productos = productos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AdapterViewProductos.ProductosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductosHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductosHolder holder, int position) {
        holder.nombre.setText(productos.get(position).getNombre());
        holder.precio.setText(productos.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductosHolder extends RecyclerView.ViewHolder {
        LinearLayout productos;
        TextView nombre;
        TextView precio;

        public ProductosHolder (View v) {
            super(v);
            productos=(LinearLayout) v.findViewById(R.id.productos);
            nombre = (TextView) v.findViewById(R.id.nombre);
            precio = (TextView) v.findViewById(R.id.precio);
        }
    }
}
