package me.kmcounter.service.distance;

public interface DistanceMatrixService {
    long getDistance(String origin, String destination) throws Exception;
}