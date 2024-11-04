package com.rama.heart2heart.chips;

public class dboard {
    String board_donation_name1;
    String quantity1;
    String age_use_game1;
    String preferred_pickup_date1;
    String preferred_pickup_time1;
    String preferred_pickup_location1;
    public dboard(String board_donation_name1, String quantity1,String age_use_game1,String preferred_pickup_date1, String preferred_pickup_time1, String preferred_pickup_location1) {
        this.board_donation_name1 = board_donation_name1;
        this.quantity1 = quantity1;
        this.age_use_game1 = age_use_game1;
        this.preferred_pickup_date1 = preferred_pickup_date1;
        this.preferred_pickup_time1 = preferred_pickup_time1;
        this.preferred_pickup_location1 = preferred_pickup_location1;
    }

    public String getBoard_donation_name1() {
        return board_donation_name1;
    }

    public String getQuantity1() {
        return quantity1;
    }
    public String getAge_use_game1() {
        return age_use_game1;
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
