package net.eldiosantos.viajabessa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import net.eldiosantos.viajabessa.R;
import net.eldiosantos.viajabessa.model.Pacote;
import net.eldiosantos.viajabessa.task.ComprarPacoteTask;
import net.eldiosantos.viajabessa.util.Constants;


/**
 * Created by Eldius on 10/02/2015.
 */
public class DetalheFragment extends Fragment {

    private Pacote pacote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detalhe_pacote, container, false);

        pacote = (Pacote) getArguments().getSerializable(Constants.PACOTE_PARAMETRO);

        TextView titulo = (TextView) view.findViewById(R.id.detail_title);
        titulo.setText(pacote.getTitulo());

        TextView descricao = (TextView) view.findViewById(R.id.detail_description);
        descricao.setText(pacote.getDescricao());

        ImageView foto = (ImageView) view.findViewById(R.id.detail_image_view);
        UrlImageViewHelper.setUrlDrawable(foto, pacote.getFoto(), view.getResources().getDrawable(R.drawable.no_foto));

        Button button = (Button) view.findViewById(R.id.button_comprar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ComprarPacoteTask(DetalheFragment.this, DetalheFragment.this.pacote.getId()).execute();
            }
        });

        return view;
    }
}
