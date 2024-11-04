package com.rama.heart2heart.chips;

public class dgrain {

    String grain_donation_name1;
    String quantity1;
    String preferred_pickup_date1;
    String preferred_pickup_time1;
    String preferred_pickup_location1;
    String year_grain1;

    public dgrain(String grain_donation_name1, String quantity1,String preferred_pickup_date1,
                  String preferred_pickup_time1, String preferred_pickup_location1, String year_grain1) {
        this.grain_donation_name1 = grain_donation_name1;
        this.quantity1 = quantity1;
        this.preferred_pickup_date1 = preferred_pickup_date1;
        this.preferred_pickup_time1 = preferred_pickup_time1;
        this.preferred_pickup_location1 = preferred_pickup_location1;
        this.year_grain1 = year_grain1;
    }

    public String getGrain_donation_name1() {
        return grain_donation_name1;
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
    public String getYear_grain1() {
        return year_grain1;
    }
}
