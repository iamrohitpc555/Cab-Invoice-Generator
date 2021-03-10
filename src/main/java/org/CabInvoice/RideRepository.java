package org.CabInvoice;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> UserRides;

    public RideRepository() {
        this.UserRides = new HashMap<>();
    }

    public void AddRide(String UserId, Ride[] ride) {
        ArrayList<Ride> RideArrayList = this.UserRides.get(UserId);
        if (RideArrayList == null) {
            this.UserRides.put(UserId, new ArrayList<Ride>((Arrays.asList(ride))));
        }
    }

    public Ride[] getRides(String UserId) {
        return this.UserRides.get(UserId).toArray(new Ride[0]);

    }
}