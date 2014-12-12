package com.example.looppuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	GridView gridView;

	static final String[] DRAWABLE = new String[] { "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Center", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Center", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Center", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Center", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Center", "Vertical",
			"Center", "Vertical", "Center", "Vertical", "Square", "Horizontal",
			"Square", "Horizontal", "Square", "Horizontal", "Square",
			"Horizontal", "Square", "Horizontal", "Square" };

	static final String[] ONE_NUMBERS = new String[] { "1,14", "2,38", "2,42",
			"2,60", "0,64", "1,82", "2,86", "2,102", "3,104", "2,106" };
	static final String[] TWO_NUMBERS = new String[] { "2,14", "2,34", "1,36",
			"1,38", "2,56", "1,58", "2,78", "3,80", "2,82", "2,106", "0,108" };
	static final String[] THREE_NUMBERS = new String[] { "1,16", "2,18",
			"1,34", "2,58", "2,62", "3,82", "2,86", "2,102", "0,104" };
	static final String[] FOUR_NUMBERS = new String[] { "3,12", "3,38", "1,40",
			"2,42", "0,56", "2,60", "2,78", "2,82", "0,84", "3,86", "3,108" };
	static final String[] FIVE_NUMBERS = new String[] { "1,14", "2,16", "2,18",
			"3,38", "0,40", "2,42", "2,64", "1,78", "2,82", "3,100", "3,108" };

	private ArrayList<Integer> ONE_SOLUTIONS = new ArrayList<Integer>(
			Arrays.asList(1, 7, 9, 11, 13, 17, 21, 27, 33, 35, 37, 43, 49, 53,
					55, 57, 61, 63, 69, 71, 77, 85, 91, 93, 97, 99, 101, 105,
					109, 111, 117, 119));
	private ArrayList<Integer> TWO_SOLUTIONS = new ArrayList<Integer>(
			Arrays.asList(1, 5, 7, 9, 11, 13, 15, 21, 27, 29, 33, 35, 41, 43,
					51, 55, 57, 61, 65, 71, 75, 77, 79, 81, 85, 91, 95, 99,
					105, 111, 113, 115));
	private ArrayList<Integer> THREE_SOLUTIONS = new ArrayList<Integer>(
			Arrays.asList(1, 3, 5, 7, 9, 11, 21, 23, 25, 29, 31, 37, 39, 47,
					51, 57, 63, 67, 71, 75, 77, 81, 83, 87, 91, 95, 99, 101,
					107, 109, 111, 119));
	private ArrayList<Integer> FOUR_SOLUTIONS = new ArrayList<Integer>(
			Arrays.asList(1, 3, 5, 7, 9, 11, 21, 23, 27, 35, 37, 39, 43, 47,
					53, 61, 63, 69, 71, 75, 79, 87, 89, 93, 97, 99, 103, 105,
					107, 111, 113, 117));
	private ArrayList<Integer> FIVE_SOLUTIONS = new ArrayList<Integer>(
			Arrays.asList(1, 7, 9, 11, 13, 17, 21, 27, 33, 35, 37, 43, 49, 53,
					55, 57, 61, 63, 69, 71, 77, 85, 91, 93, 97, 99, 101, 105,
					109, 111, 117, 119));
	
	private ArrayList<Integer> solution;
	private ArrayList<Integer> userSolution = new ArrayList<Integer>();
	
	private Button btnNewPuzzle;
	private Button btnVerify;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		gridView = (GridView) findViewById(R.id.gridView1);

		gridView = (GridView) findViewById(R.id.gridView1);
		
		Random randGen = new Random();
		int randPuzzle = randGen.nextInt(5);
		
		Log.d("randPuzzle", String.valueOf(randPuzzle));

		if(randPuzzle == 0){
			solution = new ArrayList<Integer>(ONE_SOLUTIONS);
			Log.d("solution", solution.toString());
			gridView.setAdapter(new ImageAdapter(this, DRAWABLE, ONE_NUMBERS));
			Log.d("Set Grid", "Grid view is populated.");
		} else if(randPuzzle == 1){
			solution = new ArrayList<Integer>(TWO_SOLUTIONS);
			Log.d("solution", solution.toString());
			gridView.setAdapter(new ImageAdapter(this, DRAWABLE, TWO_NUMBERS));
			Log.d("Set Grid", "Grid view is populated.");
		} else if(randPuzzle == 2){
			solution = new ArrayList<Integer>(THREE_SOLUTIONS);
			Log.d("solution", solution.toString());
			gridView.setAdapter(new ImageAdapter(this, DRAWABLE, THREE_NUMBERS));
			Log.d("Set Grid", "Grid view is populated.");
		} else if(randPuzzle == 3){
			solution = new ArrayList<Integer>(FOUR_SOLUTIONS);
			Log.d("solution", solution.toString());
			gridView.setAdapter(new ImageAdapter(this, DRAWABLE, FOUR_NUMBERS));
			Log.d("Set Grid", "Grid view is populated.");
		} else if(randPuzzle == 4){
			solution = new ArrayList<Integer>(FIVE_SOLUTIONS);
			Log.d("solution", solution.toString());
			gridView.setAdapter(new ImageAdapter(this, DRAWABLE, FIVE_NUMBERS));
			Log.d("Set Grid", "Grid view is populated.");
		} 
		
		Log.d("Before Click", "Before clicking anywhere on the grid.");
		

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Log.d("Clicked line", "Clicked the a line.");
				
				if (position % 2 != 0) {
					ImageView gridItem = (ImageView) view
							.findViewById(R.id.grid_item_image);
					String tag = gridItem.getTag().toString();
					Log.d("Tag", tag);
					if (tag.equals("false") == true) {
						Log.d("Entered", "Tag is false");
						int color = Color.parseColor("#EA6F4B");
						gridItem.setColorFilter(color);
						gridItem.setTag("true");
						userSolution.add(position);
					} else {
						int color = Color.parseColor("#7D796B");
						gridItem.setColorFilter(color);
						gridItem.setTag("false");
						userSolution.remove(new Integer(position));
					}

				}

				String posStr = String.valueOf(position);
				//Toast.makeText(getApplicationContext(), posStr,
						//Toast.LENGTH_SHORT).show();

			}
		});
		
		btnNewPuzzle = (Button) findViewById(R.id.button_reset);
        
        btnNewPuzzle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GameActivity.this, GameActivity.class);
				startActivity(intent);
			}		
        	
        });
        
        btnVerify = (Button) findViewById(R.id.button_verify);
        
        btnVerify.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Collections.sort(userSolution);
				if((userSolution.toString()).equals(solution.toString())){
					Intent intent = new Intent(GameActivity.this, WinnerActivity.class);
					startActivity(intent);
				} else {
					//Toast.makeText(getApplicationContext(),
							//"Not Quite! Keep Trying!", Toast.LENGTH_SHORT)
							//.show();
					//Toast.makeText(getApplicationContext(),
							//userSolution.toString(), Toast.LENGTH_SHORT)
							//.show();
				}
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
