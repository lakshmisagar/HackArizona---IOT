package planyourtrip.com.planyourtrip.Network;

import android.net.Uri;

/**
 * Created by "nithesh" on 1/14/2017.
 */

public class CustomUri extends BaseUri {

    public static class FlightsUri {
        public static String flights_path = "flights";
        public static String extensive_search_path = "extensive-search";
        public static String inspiration_search = "inspiration_search";

        public static String param_oneway = "one-way";
        public static String param_direct = "direct";
        public static String param_maxprice = "max_price";

        public static String airports_path = "airports";
        public static String autocomplete_path = "autocomplete";

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

        public static Uri getInspirationQueryUrl(String originCityCode, String startDate, String endDate, int priceLimit, boolean oneWay){
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority(base_url)
                    .appendPath(version_name_path)
                    .appendPath(flights_path)
                    .appendPath(inspiration_search)
                    .appendQueryParameter(param_origin, originCityCode)
                    .appendQueryParameter(param_departure_date, startDate+"--"+endDate);
            if(oneWay){
                builder.appendQueryParameter(param_oneway, "true");
            }

            if(priceLimit > 0){
                builder.appendQueryParameter(param_maxprice, String.valueOf(priceLimit));
            }
            return builder.appendQueryParameter(param_apiKey, api_key).build();

        }

        public static Uri getAirports(String searchTerm){
            Uri.Builder builder = new Uri.Builder();
            return builder.scheme("https")
                    .authority(base_url)
                    .appendPath(version_name_path)
                    .appendPath(airports_path)
                    .appendPath(autocomplete_path)
                    .appendQueryParameter(param_apiKey, api_key)
                    .appendQueryParameter(param_term, searchTerm).build();
        }
    }

    public static class HotelsUri extends BaseUri{
        private static String hotels_path = "hotels";
        private static String search_circle_path = "search-circle";

        private static String param_radius = "radius";
        private static String param_checkin = "check_in";
        private static String param_checkout = "check_out";
        private static String param_currency = "currency";
        private static String param_maxrate = "max_rate";

        public static Uri getHotels(long latitude, long longitude, long radius,String checkin, String checkout, int maxrate){
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority(base_url)
                    .appendPath(version_name_path)
                    .appendPath(hotels_path)
                    .appendPath(search_circle_path)
                    .appendQueryParameter(param_latitude, String.valueOf(latitude))
                    .appendQueryParameter(param_longitude, String.valueOf(longitude))
                    .appendQueryParameter(param_radius, String.valueOf(radius))
                    .appendQueryParameter(param_checkin, checkin)
                    .appendQueryParameter(param_checkout, checkout)
                    .appendQueryParameter(param_currency, "USD");

            if(maxrate > 0){
                builder.appendQueryParameter(param_maxrate, String.valueOf(maxrate));
            }
            return builder.appendQueryParameter(param_apiKey, api_key).build();

        }

    }
}
