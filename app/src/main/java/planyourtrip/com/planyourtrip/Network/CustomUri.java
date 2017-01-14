package planyourtrip.com.planyourtrip.Network;

import android.net.Uri;

/**
 * Created by "nithesh" on 1/14/2017.
 */

public class CustomUri extends BaseUri {

    public static class FlightsUri {
        public static String flights_path = "flights";
        public static String extensive_search_path = "extensive-search";

        public static String param_oneway = "one-way";
        public static String param_direct = "direct";
        public static String param_maxprice = "max_price";

        public static String param_airports_path = "airports";
        public static String param_autocomplete = "autocomplete";

        public static String param_term = "term";
        public static String param_all_airports = "all_airports";

        public static Uri getExtensiveQueryUrl(String originCityCode, String destCityCode, String departDate, String returnDate, int priceLimit){
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority(base_url)
                    .appendPath(version_name_path)
                    .appendPath(flights_path)
                    .appendPath(extensive_search_path)
                    .appendQueryParameter(param_origin, originCityCode)
                    .appendQueryParameter(param_destination, destCityCode)
                    .appendQueryParameter(param_departure_date, departDate+"--"+(returnDate != null ? returnDate : ""));
            if(returnDate != null){
                builder.appendQueryParameter(param_oneway, "true");
            }

            if(priceLimit > 0){
                builder.appendQueryParameter(param_maxprice, String.valueOf(priceLimit));
            }
            return builder.appendQueryParameter(param_apiKey, api_key).build();
        }
    }

    public static class HotelsUri {

    }
}
