package com.rama.heart2heart.chips;

public class dtoy {

    String age_use_toy1;
    String quantity1;
    String preferred_pickup_date1;
    String preferred_pickup_time1;
    String preferred_pickup_location1;

    public dtoy(String age_use_toy1, String quantity1,String preferred_pickup_date1, String preferred_pickup_time1, String preferred_pickup_location1) {
        this.age_use_toy1 = age_use_toy1;
        this.quantity1 = quantity1;
        this.preferred_pickup_date1 = preferred_pickup_date1;
        this.preferred_pickup_time1 = preferred_pickup_time1;
        this.preferred_pickup_location1 = preferred_pickup_location1;
    }

    public String getAge_use_toy1() {
        return age_use_toy1;
    }

    public String getQuantity1() {
        return quantity1;
    }
    public String getPreferred_pickup_date1() {
        return preferred_pickup_date1;
    }

    public String getPreferred_pickup_time1() {
        return preferred_pickup_time1;
    }
    public String getPreferred_pickup_location1() {
        return preferred_pickup_location1;
    }
}
