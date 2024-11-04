package com.rama.heart2heart.chips;

public class dutensils {

    String utensils_donation_name1;
    String quantity1;
    String preferred_pickup_date1;
    String preferred_pickup_time1;
    String preferred_pickup_location1;
    public dutensils(String utensils_donation_name1, String quantity1,String preferred_pickup_date1, String preferred_pickup_time1, String preferred_pickup_location1) {
        this.utensils_donation_name1 = utensils_donation_name1;
        this.quantity1 = quantity1;
        this.preferred_pickup_date1 = preferred_pickup_date1;
        this.preferred_pickup_time1 = preferred_pickup_time1;
        this.preferred_pickup_location1 = preferred_pickup_location1;
    }

    public String getUtensils_donation_name1() {
        return utensils_donation_name1;
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
