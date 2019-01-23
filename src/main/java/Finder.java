import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

/**
 * Main class of the program.
 *
 * The url of json resource is hadcoded for now in constant URL_JSON.
 *
 * It uses GSon library to parse json payload.
 *
 * Erros are logged into src/main/log4j.properties.
 *
 */
public class Finder {

    private final static Logger log = Logger.getLogger(Finder.class);
    private final static String URL_JSON = "http://jsonvat.com/";

    public static void main(String[] args) {

        //gets payload
        String actualVatsJSON = getJSON(URL_JSON);

        //process payload
        processPayload(actualVatsJSON);

    }

    protected static void processPayload(String actualVatsJSON) {

        //make collection of countries from payload
        Gson g = new Gson();
        Countries countries = g.fromJson(actualVatsJSON, Countries.class);

        //order the collection
        Collections.sort(countries.getRates(), new CountryComparator());

        //prints output to console
        printHighestAndLowest(countries.getRates());

    }

    private static String getJSON(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            log.error("Error during getting JSON payload", e);
        }
        return result;
    }

    private static void printHighestAndLowest(List<Country> countries) {

        if (!CollectionUtils.isEmpty(countries) && (countries.size() > 5)) {

            int csSize = countries.size();

            System.out.println("First three countries with lowest VAT rates:");

            System.out.println("1. " + returnCountryDetails(countries.get(0)));
            System.out.println("2. " + returnCountryDetails(countries.get(1)));
            System.out.println("3. " + returnCountryDetails(countries.get(2)));

            System.out.println("Last three countries with highest VAT rates:");

            System.out.println(csSize-2 + ". " + returnCountryDetails(countries.get(csSize-3)));
            System.out.println(csSize-1 + ". " + returnCountryDetails(countries.get(csSize-2)));
            System.out.println(csSize +  ". " + returnCountryDetails(countries.get(csSize-1)));

        }

        else {

            System.out.println("No countries where found.");

        }

    }

    private static String returnCountryDetails(Country country) {
        return country.getName() + " - VAT " + (country.getPeriods()!=null ? Utils.findActualPeriod(country.getPeriods()).getRates().getStandard() : "");
    }






}
