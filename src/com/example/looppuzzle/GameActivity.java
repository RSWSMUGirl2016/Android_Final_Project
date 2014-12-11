package com.example.looppuzzle;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	GridView gridView;
	
	static final String[] DRAWABLE = new String[] {"Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square",
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical",
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square",
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical",
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square",
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical",
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square",
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical",
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square",
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical", "Center", 
												   "Vertical", "Center", "Vertical",
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square", "Horizontal", 
												   "Square", "Horizontal", "Square"};
	
	static final String [] ONE_NUMBERS = new String[] {"1,14", "2,26", "2,30", "2,36", "0,40",
													   "1,46", "2,50", "2,54", "3,56", "2,58"};
	static final String [] TWO_NUMBERS = new String[] {"2,14", "2,22", "1,24", "1,26", "2,32",
		   											   "1,34", "2,42", "3,44", "2,46", "2,58",
		   											   "0,60"};
	static final String [] THREE_NUMBERS = new String[] {"1,16", "2,18", "1,22", "2,34", "2,38",
		   												 "3,46", "2,50", "2,54", "0,56"};
	static final String [] FOUR_NUMBERS = new String[] {"3,12", "3,26", "1,28", "2,30", "0,32",
			 											"2,36", "2,42", "2,46", "0,48", "3,50",
			 											"3,58"};
	static final String [] FIVE_NUMBERS = new String[] {"1,14", "2,16", "2,18", "3,26", "0,28",
														"2,30", "2,40", "1,42", "2,46", "3,52",
														"3,60"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		gridView = (GridView) findViewById(R.id.gridView1);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		
		gridView.setAdapter(new ImageAdapter(this, DRAWABLE));
 
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(position % 2 != 0){
				
					ImageView gridItem = (ImageView)view.findViewById(R.id.grid_item_image);	
					String tag = gridItem.getTag().toString();
					if(tag.equals("false") == true){
						int color = Color.parseColor("#000000");
						gridItem.setColorFilter(color);
						gridItem.setTag("true");
					} else  {
						int color = Color.parseColor("#FFFFFF");
						gridItem.setColorFilter(color);
						gridItem.setTag("false");
					}
				
				}
				
				String posStr = String.valueOf(position);
				Toast.makeText(getApplicationContext(),
						posStr, Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
