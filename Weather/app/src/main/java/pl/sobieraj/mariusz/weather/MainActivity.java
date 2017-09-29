package pl.sobieraj.mariusz.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {


    static class Cheese {
        String name;
        String description;

        public Cheese(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }
    Cheese[] cheeses = {
            new Cheese("Parmesan", "Hard, granular cheese"),
            new Cheese("Ricotta", "Italian whey cheese"),
            new Cheese("Fontina", "Italian cow's milk cheese"),
            new Cheese("Mozzarella", "Southern Italian buffalo milk cheese"),
            new Cheese("Cheddar", "Firm, cow's milk cheese"),
    };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            ArrayAdapter<Cheese> cheeseAdapter =
                    new ArrayAdapter<Cheese>(this, 0, cheeses) {
                        @Override
                        public View getView(int position,
                                            View convertView,
                                            ViewGroup parent) {

                            Cheese currentCheese = cheeses[position];

                            // Inflate only once
                            if(convertView == null) {
                                convertView = getLayoutInflater()
                                        .inflate(R.layout.activity_main, null, false);
                            }
                            return convertView;



                        static class ViewHolder{
                            TextView cheeseName;
                            TextView cheeseDescription;
                            ViewHolder viewHolder = new ViewHolder();
                            viewHolder.cheeseName =
                                    (TextView)convertView.findViewById(R.id.cheese_name);
                            viewHolder.cheeseDescription =
                                    (TextView)convertView.findViewById(R.id.cheese_description);

                            // Store results of findViewById
            convertView.setTag(viewHolder);

                            TextView cheeseName =
                                    ((ViewHolder)convertView.getTag()).cheeseName;
                            TextView cheeseDescription =
                                    ((ViewHolder)convertView.getTag()).cheeseDescription;

            cheeseName.setText(currentCheese.name);
            cheeseDescription.setText(currentCheese.description);

            }}




        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }



    }

