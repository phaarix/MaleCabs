package com.example.malecabs;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocateRequestedCustomers extends Activity {

	static final LatLng MALE = new LatLng(4.175085,73.508883);
	  //static final LatLng KIEL = new LatLng(53.551, 9.993);
	  private GoogleMap map;
	 
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locate_requested_customers);
		 map = ((MapFragment) getFragmentManager().findFragmentById(R.id.requestmap))
			        .getMap();
			    
			    /*Marker M = map.addMarker(new MarkerOptions().position(MALE)
			        .title("Male"));
			  
			    Location myCurrentLocation = map.getMyLocation();
		    	  
		        LatLng NewmyLatLng = new LatLng(myCurrentLocation.getLatitude(), myCurrentLocation.getLongitude());

		        CameraPosition myPosition = new CameraPosition.Builder().target(NewmyLatLng).zoom(17).build();
		        map.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));*/
	
			    
			    Marker male = map.addMarker(new MarkerOptions().position(MALE).title("Male").snippet("This is customer address"));
			  
			    // Move the camera instantly to male with a zoom of 15.
			    map.moveCamera(CameraUpdateFactory.newLatLngZoom(MALE, 18));

			    // Zoom in, animating the camera.
			    map.animateCamera(CameraUpdateFactory.zoomTo(16), 20, null);
			 }
	  
	  public void location(View V)
			    {
		    	 
		        return;
		         
		         }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.locate_requested_customers, menu);
		return true;
	}

}
