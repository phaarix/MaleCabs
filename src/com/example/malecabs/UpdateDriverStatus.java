package com.example.malecabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



public class UpdateDriverStatus extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_driver_status);
	 
        Button Available = (Button)findViewById(R.id.radioAvailable);
	    Button Unavailable=(Button)findViewById(R.id.radioUnavailable);

	    Available.setOnClickListener(new View.OnClickListener() 
	    {
	    public void onClick(View v) {  
	          Intent intentAvailable=new Intent(getApplicationContext(),LocateRequestedCustomers.class);
	          startActivity(intentAvailable);	           
	       }
	       });

	    Unavailable.setOnClickListener(new View.OnClickListener(){
		public void onClick(View v) {
			Toast.makeText(UpdateDriverStatus.this, "Please select available to view customer requests", Toast.LENGTH_LONG).show();
		    		
		}});
	      }}
	/*
	// Event handler for radio buttons 
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
        case R.id.radioAvailable:
            if (checked);
                Intent intentAvailable=new Intent(getApplicationContext(),LocateRequestedCustomers.class);
            	startActivity(intentAvailable);
            break;
        case R.id.radioUnavailable:
            if (checked)
                Toast.makeText(this, "Please select available to view customer requests", Toast.LENGTH_LONG).show();
            	RadioButton.setChecked(true);
            break;
        }
    }

}*/