package planyourtrip.com.planyourtrip.Model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Shrinivas on 14-01-2017.
 */

public class FlightResponse {

    private String valueOrigin = null;

    private String valueCurrency = null;

    private ArrayList<HashMap<String, String>> valueResults = new ArrayList<HashMap<String, String>>();

    private String valueDestination = null;

    private String valueDepartureDate = null;

    private String valueReturnDate = null;

    private String valuePrice = null;

    private String valueAirline = null;


    private HashMap<String,Object> response = new HashMap<String, Object>();


    public HashMap<String, Object> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, Object> response) {
        this.response = response;
    }

    public String getValueOrigin() {
        return valueOrigin;
    }

    public void setValueOrigin(String valueOrigin) {
        this.valueOrigin = valueOrigin;
    }

    public String getValueCurrency() {
        return valueCurrency;
    }

    public void setValueCurrency(String valueCurrency) {
        this.valueCurrency = valueCurrency;
    }

    public ArrayList<HashMap<String,String>> getValueResults() {
        return valueResults;
    }

    public void setValueResults(ArrayList<HashMap<String, String>> valueResults) {
        this.valueResults = valueResults;
    }

    public String getValueDestination() {
        return valueDestination;
    }

    public void setValueDestination(String valueDestination) {
        this.valueDestination = valueDestination;
    }

    public Date getValueDepartureDate() {
        return DateConveter.getDate(valueDepartureDate);
    }

    public void setValueDepartureDate(String valueDepartureDate) {
        this.valueDepartureDate = valueDepartureDate;
    }

    public Date getValueReturnDate() {
        return DateConveter.getDate(valueReturnDate);
    }

    public void setValueReturnDate(String valueReturnDate) {
        this.valueReturnDate = valueReturnDate;
    }

    public String getValuePrice() {
        return valuePrice;
    }

    public void setValuePrice(String valuePrice) {
        this.valuePrice = valuePrice;
    }

    public String getValueAirline() {
        return valueAirline;
    }

    public void setValueAirline(String valueAirline) {
        this.valueAirline = valueAirline;
    }

}