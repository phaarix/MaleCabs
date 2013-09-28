package com.example.malecabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SearchAvailableTaxi extends Activity{
  
	static final LatLng MALE = new LatLng(4.175085,73.508883);
	private GoogleMap map;
	private LocationsDb LocationsDb;
	Button location;
	LatLng myPosition;
   
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_available_taxi);
 /*   location=(Button)findViewById(R.id.button2);
*/
    //--------map---//
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
    map.setMyLocationEnabled(true);
    
    Marker male= map.addMarker(new MarkerOptions().position(MALE)
        .title("Male"));
  
    // Move the camera instantly to male with a zoom of 15.
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(MALE, 18));

    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(16), 20, null);
   
  
//---------------------------------------LOADING ADDRESSES INTO ARRAY-------------------------------------------------------------------//
  final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

  LocationsDb = new LocationsDb(SearchAvailableTaxi.this);
  LocationsDb.openDB();

  String[] addresses = LocationsDb.getAllAddresses();

  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, addresses);
  textView.setAdapter(adapter);
  
  //
}
  
  /*//------------------get current location
  
  public void location(View V)
  {
	  Location myCurrentLocation = map.getMyLocation();
      LatLng NewmyLatLng = new LatLng(myCurrentLocation.getLatitude(),
    		  myCurrentLocation.getLongitude());

      CameraPosition myPosition = new CameraPosition.Builder()
              .target(NewmyLatLng).zoom(17).build();
      map.animateCamera(
          CameraUpdateFactory.newCameraPosition(myPosition));
       }
*/

public void onDestroy()
{
	super.onDestroy();
	LocationsDb.close();
}
/////////////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.search_available_taxi, menu);
    return true;
  }

}