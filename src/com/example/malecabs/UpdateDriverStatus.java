package com.example.malecabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateDriverStatus extends Activity {

	
	private RadioGroup radioStatus;
	  private RadioButton radioStatusButton;
	  private Button btnProceed;
	  
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_driver_status);
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
		 
		radioStatus = (RadioGroup) findViewById(R.id.radioStatus);
		btnProceed = (Button) findViewById(R.id.radioButton);
		
		
		btnProceed.setOnClickListener(new OnClickListener() {
	 
			@Override
			public void onClick(View v) {
		        // get selected radio button from radioGroup
				int selectedId = radioStatus.getCheckedRadioButtonId();
	 
				/*// find the radiobutton by returned id
		        btnProceed = (RadioButton) findViewById(selectedId);

		        Toast.makeText(UpdateDriverStatus.this,
				btnProceed.getText(), Toast.LENGTH_SHORT).show();    
		        };*/
						
				//String radioButtonSelected = "";    
			    switch (selectedId) 
			    {
			          case R.id.radioAvailable : selectedId = 1;
			          
			          Intent intentlogin=new Intent(getApplicationContext(),Home.class);
		    			startActivity(intentlogin);
			                           	              break;
			          case R.id.radioUnavailable : selectedId = 2;
			        		                      break;
			    };
			};
		});
	}}