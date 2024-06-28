package me.kmcounter.service.distance;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class GeocodingService {

    public String getCoordinatesFromCep(String cep) throws Exception {
        String url = "https://nominatim.openstreetmap.org/search?postalcode=" + cep + "&country=Brazil&format=json&limit=1";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String json = EntityUtils.toString(response.getEntity());
                JSONArray results = new JSONArray(json);
                if (results.length() > 0) {
                    JSONObject result = results.getJSONObject(0);
                    String lat = result.getString("lat");
                    String lon = result.getString("lon");
                    return lon + "," + lat;
                } else {
                    throw new Exception("CEP não encontrado");
                }
            }
        }
    }
}
