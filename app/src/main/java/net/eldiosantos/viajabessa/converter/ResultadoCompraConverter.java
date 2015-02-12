package net.eldiosantos.viajabessa.converter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Eldius on 11/02/2015.
 */
public class ResultadoCompraConverter {
    public String fromJSON(final String json) throws JSONException {
        return new JSONObject(json).getString("string");
    }
}
