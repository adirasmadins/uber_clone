package usmanali.uberclone;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Calendar;

public class Trip_Detail extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView base_fare,estimated_payout,txt_from,txt_to,txt_date,txt_fee,txt_time,txt_distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        base_fare=(TextView)findViewById(R.id.base_fare);
        estimated_payout=(TextView)findViewById(R.id.estimated_payout);
        txt_from=(TextView)findViewById(R.id.txt_from);
        txt_date=(TextView)findViewById(R.id.txt_date);
        txt_to=(TextView) findViewById(R.id.txt_to);
        txt_fee=(TextView) findViewById(R.id.txt_fee);
        txt_time=(TextView) findViewById(R.id.txt_time);
        txt_distance=(TextView) findViewById(R.id.txt_distance);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap=googleMap;
        try {
            boolean issucess = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(Trip_Detail.this, R.raw.uber_style_map));
            if (!issucess)
                Toast.makeText(Trip_Detail.this, "Error setting Map Style", Toast.LENGTH_LONG).show();
        }catch(Resources.NotFoundException ex){ex.printStackTrace();}
        Setting_information();
    }

    private void Setting_information() {
        if(getIntent()!=null){
            Calendar calendar=Calendar.getInstance();
            String Date=String.format("%s,  %d,%d",convert_to_days_of_week(calendar.get(Calendar.DAY_OF_WEEK)),calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH));
            txt_date.setText(Date);
            txt_fee.setText(String.format("$ %.2f",getIntent().getDoubleExtra("Total",0.0)));
            base_fare.setText(String.valueOf(commons.base_fare));
            estimated_payout.setText(String.format("$ %.2f",getIntent().getDoubleExtra("Total",0.0)));
            txt_time.setText(String.format("%s min",getIntent().getStringExtra("Time")));
            txt_distance.setText(String.format("%s km",getIntent().getStringExtra("Distance")));
            txt_from.setText(getIntent().getStringExtra("start_address"));
            txt_to.setText(getIntent().getStringExtra("end_address"));
            String[] location_end=getIntent().getStringExtra("Location_end").split(",");
            LatLng drop_off=new LatLng(Double.parseDouble(location_end[0]),Double.parseDouble(location_end[1]));
            mMap.addMarker(new MarkerOptions().position(drop_off).title("Drop off Here").icon(BitmapDescriptorFactory.fromResource(R.drawable.destination_marker)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(drop_off,12.0f));
        }
    }

    private String convert_to_days_of_week(int i) {
        switch(i) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.SATURDAY:
                return "Saturday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.MONDAY:
                return "Monday";
                default:
                    return "unx";
        }
    }
}
