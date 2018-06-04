package com.example.matnguyen.shoponline_v1.Controller;

import android.content.Context;
import android.os.AsyncTask;

import com.example.matnguyen.shoponline_v1.Model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<Integer, String, ArrayList<Product>>{

    private Context context;
    ArrayList<Product> products = new ArrayList<>();
    public MyAsyncTask(Context c){
        this.context = c;
    }

    @Override
    public ArrayList<Product> doInBackground(Integer... integers) {
        int product_id = -1;
        try {
            product_id = integers[0].intValue();
            URL url = new URL(Config.URL + Config.URL_PRODUCT + "/" + product_id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
            connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");


            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                builder.append(line);
            }
            bufferedReader.close();
            System.out.println(builder.toString());

            JSONObject jsonObject = new JSONObject(builder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("product");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt("id");
                String name = object.getString("name");
                String image = object.getString("image");
                int price = object.getInt("price");
                String description = object.getString("description");
                Product product = new Product(id, name, image, price, description);
                products.add(product);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return products;
    }

}
