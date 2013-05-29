package nl.marnik.dev1app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import static java.lang.System.out;

public class MainPage extends Activity {
	
	Button add, showP, showS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		add = (Button) findViewById(R.id.bAddS);
		showP = (Button) findViewById(R.id.bShowPhoto);
		showS = (Button) findViewById(R.id.bShowStats);
		
		add.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		    	  Intent toAddPage = new Intent(MainPage.this, AddPage.class);
		    	  startActivity(toAddPage);
		      }

		    });
		
		showP.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		    	  Intent toPhotoPage = new Intent(MainPage.this, PhotoPage.class);
		    	  startActivity(toPhotoPage);
		      }

		    });
		
		showS.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		    	  Intent toStatisticsPage = new Intent(MainPage.this, StatisticsPage.class);
		    	  startActivity(toStatisticsPage);
		      }

		    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
