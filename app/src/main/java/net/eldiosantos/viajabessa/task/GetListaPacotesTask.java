package net.eldiosantos.viajabessa.task;

import android.os.AsyncTask;

import net.eldiosantos.viajabessa.client.WebClient;
import net.eldiosantos.viajabessa.converter.PacoteConverter;
import net.eldiosantos.viajabessa.model.Pacote;

import org.json.JSONException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eldius on 10/02/2015.
 */
public class GetListaPacotesTask extends AsyncTask<Void, Void, List<Pacote>> {
    @Override
    protected List<Pacote> doInBackground(Void... params) {
        try {
            return new PacoteConverter().fromJSONArray(new WebClient("package/json").get());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    protected void onPostExecute(List<Pacote> pacotes) {
        super.onPostExecute(pacotes);
    }
}
