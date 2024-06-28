package me.kmcounter.service.distance;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenRouteService {

    @Value("${openrouteservice.api.key}")
    private String apiKey;

    public double getDistance(String start, String end) throws Exception {
        String url = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" + apiKey + "&start=" + start + "&end=" + end;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String json = EntityUtils.toString(response.getEntity());
                JSONObject obj = new JSONObject(json);
                JSONArray routes = obj.getJSONArray("routes");
                JSONObject route = routes.getJSONObject(0);
                JSONObject summary = route.getJSONObject("summary");
                return summary.getDouble("distance") / 1000;  // Convertendo de metros para quilômetros
            }
        }
    }
}
