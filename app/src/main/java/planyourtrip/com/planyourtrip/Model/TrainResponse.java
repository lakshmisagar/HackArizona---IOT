package planyourtrip.com.planyourtrip.Model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shrinivas on 14-01-2017
 */

public class TrainResponse {
    private ArrayList<HashMap<String,Object>> valueResults = new ArrayList<HashMap<String, Object>>();
    private HashMap<String, String> valueOrigin = new HashMap<String, String>();
    private String valueOriginStationId = null;
    private String valueOriginStationName = null;
    private HashMap<String, String> valueDestination = new HashMap<String, String>();
    private String valueDestinationStationId = null;
    private String valueDestinationStationName = null;
    private ArrayList<HashMap<String,Object>> valueItineraries = new ArrayList<HashMap<String, Object>>();
}