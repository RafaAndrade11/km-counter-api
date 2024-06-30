package me.kmcounter.service.distance.impl;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElementStatus;
import me.kmcounter.service.distance.DistanceMatrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DistanceMatrixServiceImpl implements DistanceMatrixService {


    private final GeoApiContext context;

    public DistanceMatrixServiceImpl(@Value("${google.api.key}") String apiKey) {
        this.context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    @Override
    public long getDistance(String origin, String destination) throws Exception {
        DistanceMatrix result = DistanceMatrixApi.getDistanceMatrix(context, new String[]{origin}, new String[]{destination}).await();

        if (result.rows[0].elements[0].status == DistanceMatrixElementStatus.OK) {
            long distanceInMeters = result.rows[0].elements[0].distance.inMeters;
            return distanceInMeters / 1000;
        } else {
            throw new Exception("Error calculating distance: " + result.rows[0].elements[0].status);
        }
    }
}

