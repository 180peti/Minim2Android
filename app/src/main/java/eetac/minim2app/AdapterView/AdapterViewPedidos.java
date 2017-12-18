package eetac.minim2app.AdapterView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import eetac.minim2app.Modelo.Pedido;
import eetac.minim2app.Modelo.Producto;
import eetac.minim2app.R;

/**
 * Created by Alex Aguilera on 18/12/2017.
 */

public class AdapterViewPedidos extends RecyclerView.Adapter<AdapterViewPedidos.PedidosHolder> {
    private List<Pedido> pedidos;
    private int rowLayout;
    private Context context;

    public AdapterViewPedidos(List<Pedido> pedidos,int rowLayout, Context context) {
        this.pedidos=pedidos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AdapterViewPedidos.PedidosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AdapterViewPedidos.PedidosHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewPedidos.PedidosHolder holder, int position) {
        holder.nombre.setText(productos.get(position).getNombre());
        holder.precio.setText(productos.get(position).getPrecio());
        holder.cantidad.setText(cantidades.get(productos.get(position).getNombre()));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class PedidosHolder extends RecyclerView.ViewHolder {
        LinearLayout productos;
        TextView nombre;
        TextView precio;
        TextView cantidad;

        public PedidosHolder (View v) {
            super(v);
            productos=(LinearLayout) v.findViewById(R.id.productos);
            nombre = (TextView) v.findViewById(R.id.nombre);
            precio = (TextView) v.findViewById(R.id.precio);
            cantidad = (TextView) v.findViewById(R.id.cantidad);
        }
    }
}
