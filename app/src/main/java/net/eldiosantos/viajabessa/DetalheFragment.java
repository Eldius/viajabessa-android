package net.eldiosantos.viajabessa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.eldiosantos.viajabessa.model.Pacote;
import net.eldiosantos.viajabessa.util.Constants;

import java.io.Serializable;

/**
 * Created by Eldius on 10/02/2015.
 */
public class DetalheFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detalhe_pacote, container, false);

        Pacote pacote = (Pacote) getArguments().getSerializable(Constants.PACOTE_PARAMETRO);

        TextView titulo = (TextView) view.findViewById(R.id.detail_title);
        titulo.setText(pacote.getTitulo());

        TextView descricao = (TextView) view.findViewById(R.id.detail_description);
        descricao.setText(pacote.getDescricao());

        return view;
    }
}
