package net.eldiosantos.viajabessa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.eldiosantos.viajabessa.adapter.PacoteListAdapter;
import net.eldiosantos.viajabessa.R;
import net.eldiosantos.viajabessa.model.Pacote;
import net.eldiosantos.viajabessa.task.GetListaPacotesTask;
import net.eldiosantos.viajabessa.util.Logger;

import java.util.List;

/**
 * Created by Eldius on 10/02/2015.
 */
public class ListaPacotesFragment extends Fragment {

    private ListView listView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.layout_listagem, container, false);

        Logger.log("ListaPacotesFragment.onCreateView...");
        new GetListaPacotesTask(this).execute();

        listView = (ListView) layout.findViewById(R.id.lista_pacotes);
        Logger.log("ListaPacotesFragment.onCreateView.");
        return layout;
    }

    public void setListItems(final List<Pacote> pacotes) {
        listView.setAdapter(new PacoteListAdapter(this, pacotes));
    }
}
