package nl.marnik.dev1app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPage extends Activity implements View.OnClickListener{

	Button submitWeight, takePhoto;
	EditText weight;
	TextView showCurWeight;
	final static int cameraData = 0;
	Bitmap bmp;
	ImageView iv;
	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addpage);
		initialize();
		
	}
	
	private void initialize(){
		
		submitWeight = (Button) findViewById(R.id.bSubmitWeight);
		weight = (EditText) findViewById(R.id.etAddWeight);
		showCurWeight = (TextView) findViewById(R.id.tvCurrentWeightNumber);
		takePhoto = (Button) findViewById(R.id.bTakePhoto);
		iv = (ImageView) findViewById(R.id.ivYourPhoto);
		
		submitWeight.setOnClickListener(this);
		takePhoto.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSubmitWeight:
			String currentWeight = weight.getText().toString();
			showCurWeight.setText(currentWeight+" KG");
			break;
		case R.id.bTakePhoto:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);;
			break;
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}
	
}
