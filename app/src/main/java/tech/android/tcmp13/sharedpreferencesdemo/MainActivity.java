package tech.android.tcmp13.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ChefsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Setup UI
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.myFavouriteChefsSpinner);

        //Setup Data
        adapter = new ChefsAdapter(this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        SharedPreferences sharedPrefChef = getSharedPreferences("Shared_Pref_Chef", MODE_PRIVATE);
        if (!sharedPrefChef.contains("los_chef"))
            return;
        spinner.setSelection(adapter.indexOf(sharedPrefChef.getString("los_chef", "Gordon Ramsay")));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        //If the user selected a favourite chef, he must see it on next app launch.
        SharedPreferences sharedPrefChef = getSharedPreferences("Shared_Pref_Chef", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefChef.edit();
        editor.putString("los_chef", adapter.getItem(position).toString());
        //If changes happen frequently (less than a second delay usually) it is recommended to apply in onPause().
        editor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
