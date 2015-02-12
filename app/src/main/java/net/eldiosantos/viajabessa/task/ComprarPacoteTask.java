package net.eldiosantos.viajabessa.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import net.eldiosantos.viajabessa.client.WebClient;
import net.eldiosantos.viajabessa.converter.ResultadoCompraConverter;
import net.eldiosantos.viajabessa.fragment.DetalheFragment;
import net.eldiosantos.viajabessa.util.Logger;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Eldius on 10/02/2015.
 */
public class ComprarPacoteTask extends AsyncTask<Void, Void, String> {

    private final DetalheFragment detalhe;
    private final Long pacoteId;
    private ProgressDialog dialog = null;

    public ComprarPacoteTask(DetalheFragment detalhe, Long pacoteId) {
        this.detalhe = detalhe;
        this.pacoteId = pacoteId;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(detalhe.getActivity(), "", "Loading. Please wait...", true);
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            return new ResultadoCompraConverter().fromJSON(new WebClient("package/json/-ID-/buy".replace("-ID-", "" + pacoteId) ).get());
        } catch (IOException e) {
            Logger.log(e.getMessage());
        } catch (JSONException e) {
            Logger.log(e.getMessage());
        }
        return "";
    }

    @Override
    protected void onPostExecute(String resultado) {
        dialog.cancel();
        Toast.makeText(detalhe.getActivity(), resultado, Toast.LENGTH_LONG).show();
    }
}
