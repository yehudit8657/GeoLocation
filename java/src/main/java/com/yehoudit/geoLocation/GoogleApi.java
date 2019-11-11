package com.yehoudit.geoLocation;

import com.yehoudit.geoLocation.Exception.AddressNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleApi {

    public JSONObject json = null;
    public JSONObject distanceDetails = null;
    private static final String API_KEY = "AIzaSyCeBdq7rr-R7w7vZCXscLWgEDb3oO9CUhw";

    public GoogleApi() {
    }

    public JSONObject callGoogleAPI(String source, String dest) throws UnsupportedEncodingException, Exception {

        // only if their aren't utf8
        String source2 = URLEncoder.encode(source, "UTF-8");
        String dest2 = URLEncoder.encode(dest, "UTF-8");
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + source2 + "&destination=" + dest2 +"&key=%20"+API_KEY;

        try {
            readJsonFromUrl(url);
        } catch (IOException ex) {
            Logger.getLogger(GoogleApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GoogleApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            JSONArray array = (JSONArray) json.get("routes");
            JSONObject obj = (JSONObject) array.get(0);
            JSONArray array1 = (JSONArray) obj.get("legs");
            distanceDetails = (JSONObject) array1.get(0);
        } catch (Exception e) {
            throw new AddressNotFoundException("המקומות שהזנת לא אותרו. בדוק שנית את תקינותם");
        }
        return distanceDetails;
    }

    public void readJsonFromUrl(String url) throws IOException, ParseException {
        createTrustManager();
        try {
            int read;
            char[] chars = new char[1024];
            URL urlPath = new URL(url);
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlPath.openStream()));
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(buffer.toString());
        } catch (IOException | org.json.simple.parser.ParseException ioe) {
            ioe.printStackTrace();
        }
    }

    public void createTrustManager() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {;
        }
    }

}
