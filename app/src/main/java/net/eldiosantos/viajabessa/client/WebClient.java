package net.eldiosantos.viajabessa.client;

import net.eldiosantos.viajabessa.Constants;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WebClient {

	private final String url;

	public WebClient(String url) {
		super();
		this.url = Constants.BASE_URL + url;
	}

	public String post(final String json) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpPost post = new HttpPost(url);
		post.setEntity(new StringEntity(json));
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-type", "application/json");

		return execMethod(post);
	}

    public String get() throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);
        get.setHeader("Accept", "application/json");
        get.setHeader("Content-type", "application/json");

        return execMethod(get);
    }

    private String execMethod(HttpUriRequest request) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpResponse response = httpClient.execute(request);
        final String jsonDeResposta = EntityUtils.toString(response.getEntity());
        return jsonDeResposta;
    }
}
