package planyourtrip.com.planyourtrip.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Shrinivas on 14-01-2017.
 */

public class FlightResponse {

    private String origin = null;

    private String currency = null;

    private ArrayList<Result> results = new ArrayList<Result>();

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}

class Result {

    private String destination = null;

    private String departure_date = null;

    private String return_date = null;

    private String price = null;

    private String airline = null;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}