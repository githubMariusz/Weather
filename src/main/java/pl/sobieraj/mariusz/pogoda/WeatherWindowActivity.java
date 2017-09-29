package pl.sobieraj.mariusz.pogoda;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class WeatherWindowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_window);

        findViewById(R.id.start_button)
                .setOnClickListener(new View.OnClickListener() {


                    Intent intent = getIntent();
                    String name1 = intent.getStringExtra("name");


                    @Override
                    public void onClick(View v) {
                        new WebServiceHandler()
                                //.execute("http://http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
                                //.execute("http://samples.openweathermap.org/data/2.5/weather?id=" + nazwa);
                        .execute("http://api.openweathermap.org/data/2.5/weather?id="+ name1);
                    }
                });

    }

    private class WebServiceHandler extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog = new ProgressDialog(WeatherWindowActivity.this);

        @Override
        protected void onPreExecute() {

            dialog.setMessage("Please wait...");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                URLConnection connection = url.openConnection();


                InputStream in = new BufferedInputStream(
                        connection.getInputStream());
                return streamToString(in);

            } catch (Exception e) {

                Log.d(WeatherWindowActivity.class.getSimpleName(), e.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String  result) {

            dialog.dismiss();

            try {

                JSONObject json = new JSONObject(result);

                ((TextView) findViewById(R.id.response_id)).setText(String.format("id: %s", json.optString("id")));
                ((TextView) findViewById(R.id.response_name)).setText(String.format("name: %s", json.optString("name")));

                JSONObject reader = new JSONObject(result);
                JSONObject main  = reader.getJSONObject("main");

                ((TextView) findViewById(R.id.response_temp)).setText(String.format("Temperature : %s", main.optString("temp")+("  'C")));
                ((TextView) findViewById(R.id.response_press)).setText(String.format("Pressure:  %s", main.optString("pressure")+("  hPa")));
                ((TextView) findViewById(R.id.response_hum)).setText(String.format("Humidity:  %s", main.optString("humidity")+("  %")));

                JSONObject readerWind =new JSONObject(result);
                JSONObject wind =readerWind.getJSONObject("wind");

                ((TextView) findViewById(R.id.respone_speed)).setText(String.format("Speed wind: %s",wind.optString("speed")+("  km/h")));


            } catch (Exception e) {

                Log.d(WeatherWindowActivity.class.getSimpleName(), e.toString());
            }
        }
    }
    public static String streamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            reader.close();

        } catch (IOException e) {

            Log.d(WeatherWindowActivity.class.getSimpleName(), e.toString());
        }

        return stringBuilder.toString();
    }


    public void closeActivity(View view) {

        finish();
    }

}






