package net.eldiosantos.viajabessa.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.eldiosantos.viajabessa.R;
import net.eldiosantos.viajabessa.fragment.ListaPacotesFragment;
import net.eldiosantos.viajabessa.model.Pacote;
import net.eldiosantos.viajabessa.util.Logger;

import java.util.List;

/**
 * Created by Eldius on 10/02/2015.
 */
public class PacoteListAdapter extends BaseAdapter {

    private List<Pacote>lista;
    private final ListaPacotesFragment fragment;

    public PacoteListAdapter(ListaPacotesFragment fragment, List<Pacote> lista) {
        this.fragment = fragment;
        this.lista = lista;
        Logger.log("tamanho lista: " + lista.size());
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView==null) {
            view = fragment.getActivity().getLayoutInflater().inflate(R.layout.layout_item_lista, null);
        } else {
            view = convertView;
        }

        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        TextView valor = (TextView) view.findViewById(R.id.valor);

        titulo.setText(lista.get(position).getTitulo());
        valor.setText("por apenas: " + lista.get(position).getValor().toString());

        notifyDataSetChanged();

        return view;
    }
}
