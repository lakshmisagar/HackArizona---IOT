package planyourtrip.com.planyourtrip.Model;

import java.util.ArrayList;

/**
 * Created by Shrinivas on 14-01-2017.
 */

public class Airports {
    ArrayList<AirportDetails> airDet = new ArrayList<AirportDetails>();

    public ArrayList<AirportDetails> getAirDet() {
        return airDet;
    }

    public void setAirDet(ArrayList<AirportDetails> airDet) {
        this.airDet = airDet;
    }
}


