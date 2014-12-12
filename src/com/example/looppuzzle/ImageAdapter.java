package com.example.looppuzzle;

import java.util.Arrays;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
import com.example.looppuzzle.R;
 
public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] drawValues;
	private final Integer[] numValues;
	private final Integer[] posValues;
 
	public ImageAdapter(Context context, String[] drawValues, String [] gameValues) {
		Log.d("Entered", "In ImageAdapter");
		this.context = context;
		this.drawValues = drawValues;
		//Log.d("DrawValues", drawValues.toString());
		numValues = new Integer[gameValues.length];
		posValues = new Integer[gameValues.length];
		for(int i = 0; i < gameValues.length; i++){
			//Log.d("In Loop", "Entered the loop where we designate the numbers and positions");
			String [] numPos = gameValues[i].split(",");
			numValues[i] = Integer.parseInt(numPos[0]);
			posValues[i] = Integer.parseInt(numPos[1]);
			Log.d("Position Values", String.valueOf(posValues[i]));
		}
		
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
		
		//Log.d("position", String.valueOf(position));
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.drawable, null);
 
			// set value into textview
			//TextView textView = (TextView) gridView
			//		.findViewById(R.id.grid_item_label);
			//textView.setText(drawValues[position]);
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);
 
			String draw = drawValues[position];
			//Log.d("Drawable", "Object being drawn: " + draw);
 
			if (draw.equals("Square")) {
				imageView.setImageResource(R.drawable.square);
			} else if (draw.equals("Horizontal")) {
				imageView.setImageResource(R.drawable.hori_rect);
			} else if (draw.equals("Vertical")) {
				imageView.setImageResource(R.drawable.vert_rect);
			} else {
				Log.d("position", String.valueOf(position));
				//Log.d("Position Values", posValues.toString());
				imageView.setImageResource(R.drawable.square_with_number);
				int index = (Arrays.asList(posValues)).indexOf(position);
				Log.d("index", String.valueOf(index));
				if(index != -1){
					Log.d("Index is found", String.valueOf(index));
					TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
					textView.setText(String.valueOf(numValues[index]));
				}
			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return drawValues.length;
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}