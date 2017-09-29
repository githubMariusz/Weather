package pl.sobieraj.mariusz.pogoda;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class Pogoda_Activity extends ListActivity {


    String[] city1 = new String[]{
            ("7533560&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7532249&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7532536&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7531136&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("753268&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7531679&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7533109&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7531410&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7530983&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7533524&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7531926&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7533434&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7532559&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7533365&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7530730&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7531689&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("7532895&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),


            ("2643743&APPID=9f1993bce55cb6d6c65401833ecd45e0&units=metric"),
            ("524901&APPID=252f36f2f8d4faffc7ed6d9c6cfeb98d&units=metric"),
            ("2172797&appid=35e6a0b242fc4c8c37c22d0de17c6d7c&units=metric"),


    };
    String[]city=new  String[]{
            ("Aleksandrów Lódzki"),
            ("Brzeg"),
            ("Bytom"),
            ("Bukowina Tatrzańska"),
            ("Chełmno"),
            ("Kalisz"),
            ("Kąty Wrocławskie"),
            ("Koło"),
            ("Koszalin"),
            ("Lask"),
            ("Warszawa"),
            ("Wieluń"),
            ("Wisła"),
            ("Wołomin"),
            ("Zamość"),
            ("Piątnica"),
            ("Żywiec"),

            ("LONDYN"),
            ("Moskwa"),
            ("Caris"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogoda_);



       findViewById(R.id.list);



    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,city);

        getListView().setAdapter(adapter);



     getListView().setOnItemClickListener(new AdapterView.OnItemClickListener(){

      @Override
     public  void  onItemClick(AdapterView<?> parent, View view, int position, long id){

  // Toast.makeText(getApplicationContext(),"Position:  " +position +
         //  "  Item " + city[position], Toast.LENGTH_LONG).show();

          Intent intent = new Intent(getApplicationContext(), WeatherWindowActivity.class);
          intent.putExtra("name", city1[position] );
          startActivity(intent);

     }

    });

    }

}
