package net.eldiosantos.viajabessa.converter;

import net.eldiosantos.viajabessa.model.Pacote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldius on 10/02/2015.
 */
public class PacoteConverter {
    public Pacote fromSingleJSON(final String json) throws JSONException {
        Pacote result = new Pacote();

        JSONObject jsonObject = new JSONObject(json);

        return parseJSONObject(jsonObject);

    }

    private Pacote parseJSONObject(JSONObject jsonObject) throws JSONException {
        return new Pacote().setDescricao(jsonObject.getString("descricao"))
                .setId(jsonObject.getLong("id"))
                .setTitulo(jsonObject.getString("titulo"))
                .setValor(new BigDecimal(jsonObject.getString("valor")));
    }

    public List<Pacote> fromJSONArray(final String json) throws JSONException {
        List<Pacote> results = new ArrayList<>();

        JSONArray array = new JSONObject(json).getJSONArray("list");
        for(int index = 0; index < array.length(); index++) {
            results.add(parseJSONObject(array.getJSONObject(index)));
        }

        return results;
    }
}
