package net.eldiosantos.viajabessa.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import net.eldiosantos.viajabessa.client.WebClient;
import net.eldiosantos.viajabessa.converter.PacoteConverter;
import net.eldiosantos.viajabessa.fragment.ListaPacotesFragment;
import net.eldiosantos.viajabessa.model.Pacote;
import net.eldiosantos.viajabessa.util.Logger;

import org.json.JSONException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eldius on 10/02/2015.
 */
public class GetListaPacotesTask extends AsyncTask<Void, Void, List<Pacote>> {

    private final ListaPacotesFragment context;
    private ProgressDialog dialog = null;

    public GetListaPacotesTask(ListaPacotesFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        Logger.log("GetListaPacotesTask.onPreExecute...");
        dialog = ProgressDialog.show(context.getActivity(), "", "Loading. Please wait...", true);
        Logger.log("GetListaPacotesTask.onPreExecute.");
    }

    @Override
    protected List<Pacote> doInBackground(Void... params) {
        Logger.log("GetListaPacotesTask.doInBackground...");
        try {
            return new PacoteConverter().fromJSONArray(new WebClient("package/json").get());
        } catch (IOException e) {
            Logger.log(e.getMessage());
        } catch (JSONException e) {
            Logger.log(e.getMessage());
        }
        Logger.log("GetListaPacotesTask.doInBackground.");
        return Collections.emptyList();
    }

    @Override
    protected void onPostExecute(List<Pacote> pacotes) {
        Logger.log("GetListaPacotesTask.onPostExecute...");
        Logger.log("Resultados: " + pacotes.size());
        context.setListItems(pacotes);
        dialog.cancel();
        Logger.log("GetListaPacotesTask.onPostExecute.");
    }
}
