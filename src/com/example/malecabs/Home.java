package com.example.malecabs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends Activity {

	Button btnLoginDriver,btnSearchTaxi;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
     // Get The Refference Of Buttons
        btnLoginDriver=(Button)findViewById(R.id.login_driver);
        btnSearchTaxi=(Button)findViewById(R.id.search_taxi);
        
        btnLoginDriver.setOnClickListener(new View.OnClickListener() 
        {
    		public void onClick(View v)
    		{
    			// TODO Auto-generated method stub
    			
    			/// Create Intent for Login  and Start The Activity
    			Intent intentlogin=new Intent(getApplicationContext(),DriverLogin.class);
    			startActivity(intentlogin);
    		}
    	});
    	    
       btnSearchTaxi.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) 
        {
 		// TODO Auto-generated method stub
			
			/// Create Intent for Seaerh  and Start The Activity
			Intent intentsearch=new Intent(getApplicationContext(),SearchAvailableTaxi.class);
			startActivity(intentsearch);
        	}
		});
    }
}