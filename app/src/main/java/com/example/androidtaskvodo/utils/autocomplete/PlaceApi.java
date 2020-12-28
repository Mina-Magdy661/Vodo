package com.example.androidtaskvodo.utils.autocomplete;

import com.google.android.gms.location.FusedLocationProviderClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PlaceApi {

  public PlaceApi() {
  }

  private FusedLocationProviderClient fusedLocationProviderClient;

  public ArrayList<String> autocomplete(String input) {

    ArrayList<String> arrayList = new ArrayList();
    HttpURLConnection connection = null;
    StringBuilder jsonResult = new StringBuilder();

    try {
      StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json?");
      sb.append("input=" + input);
      sb.append("&key=AIzaSyAPFni3t26DtJiN3GO2k8fk0sp1H19Ptdg");
      URL url = new URL(sb.toString());
      connection = (HttpURLConnection) url.openConnection();
      InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
      int read;
      char[] buff = new char[1024];
      while ((read = inputStreamReader.read(buff)) != -1) {
        jsonResult.append(buff, 0, read);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }

    try {
      JSONObject jsonObject = new JSONObject(jsonResult.toString());
      JSONArray predicions = jsonObject.getJSONArray("predictions");
      for (int i = 0; i < predicions.length(); i++) {
        arrayList.add(predicions.getJSONObject(i).getString("description"));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return arrayList;
  }

}
