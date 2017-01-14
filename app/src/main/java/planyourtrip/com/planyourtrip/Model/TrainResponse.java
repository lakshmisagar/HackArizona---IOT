package planyourtrip.com.planyourtrip.Model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shrinivas on 14-01-2017
 */

public class TrainResponse {
    private ArrayList<HashMap<String,Object>> results = new ArrayList<HashMap<String, Object>>();
    private HashMap<String, StationDetails> origin = new HashMap<String, StationDetails>();
    private HashMap<String, StationDetails> destination = new HashMap<String, StationDetails>();
    private ArrayList<Trains> itineraries = new ArrayList<Trains>();

    public ArrayList<HashMap<String, Object>> getResults() {
        return results;
    }

    public void setResults(ArrayList<HashMap<String, Object>> results) {
        this.results = results;
    }

    public HashMap<String, StationDetails> getOrigin() {
        return origin;
    }

    public void setOrigin(HashMap<String, StationDetails> origin) {
        this.origin = origin;
    }

    public HashMap<String, StationDetails> getDestination() {
        return destination;
    }

    public void setDestination(HashMap<String, StationDetails> destination) {
        this.destination = destination;
    }

    public ArrayList<Trains> getItineraries() {
        return itineraries;
    }

    public void setItineraries(ArrayList<Trains> itineraries) {
        this.itineraries = itineraries;
    }
}

class StationDetails {
    private String station_id = null;
    private String station_name = null;

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
}

class Trains {
    private ArrayList<TrainDetails> trains = new ArrayList<TrainDetails>();

    public ArrayList<TrainDetails> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<TrainDetails> trains) {
        this.trains = trains;
    }
}

class TrainDetails {
    private String departs_at = null;
    private StationDetails departure_station = null;
    private String arrives_at = null;
    private StationDetails arrival_station = null;
    private String marketing_company = null;
    private String operating_company = null;
    private String train_number = null;
    private String train_type = null;
    private ArrayList<PriceDetails> prices = new ArrayList<PriceDetails>();

    public String getDeparts_at() {
        return departs_at;
    }

    public void setDeparts_at(String departs_at) {
        this.departs_at = departs_at;
    }

    public StationDetails getDeparture_station() {
        return departure_station;
    }

    public void setDeparture_station(StationDetails departure_station) {
        this.departure_station = departure_station;
    }

    public String getArrives_at() {
        return arrives_at;
    }

    public void setArrives_at(String arrives_at) {
        this.arrives_at = arrives_at;
    }

    public StationDetails getArrival_station() {
        return arrival_station;
    }

    public void setArrival_station(StationDetails arrival_station) {
        this.arrival_station = arrival_station;
    }

    public String getMarketing_company() {
        return marketing_company;
    }

    public void setMarketing_company(String marketing_company) {
        this.marketing_company = marketing_company;
    }

    public String getOperating_company() {
        return operating_company;
    }

    public void setOperating_company(String operating_company) {
        this.operating_company = operating_company;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public ArrayList<PriceDetails> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<PriceDetails> prices) {
        this.prices = prices;
    }
}

class PriceDetails {
    private String service_class = null;
    private String booking_code = null;
    private String accomodation = null;
    private TotalPrice total_price = null;
    private Rate rate = null;

    public String getService_class() {
        return service_class;
    }

    public void setService_class(String service_class) {
        this.service_class = service_class;
    }

    public String getBooking_code() {
        return booking_code;
    }

    public void setBooking_code(String booking_code) {
        this.booking_code = booking_code;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public TotalPrice getTotal_price() {
        return total_price;
    }

    public void setTotal_price(TotalPrice total_price) {
        this.total_price = total_price;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}

class TotalPrice {
    private String amount = null;
    private String currency = null;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

class Rate {
    private String rate_code = null;
    private String rate_name = null;
    private String restrictions = null;

    public String getRate_code() {
        return rate_code;
    }

    public void setRate_code(String rate_code) {
        this.rate_code = rate_code;
    }

    public String getRate_name() {
        return rate_name;
    }

    public void setRate_name(String rate_name) {
        this.rate_name = rate_name;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
}