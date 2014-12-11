package com.example.looppuzzle;

import android.content.Context;
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
 
	public ImageAdapter(Context context, String[] drawValues) {
		this.context = context;
		this.drawValues = drawValues;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
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
 
			if (draw.equals("Square")) {
				imageView.setImageResource(R.drawable.square);
			} else if (draw.equals("Horizontal")) {
				imageView.setImageResource(R.drawable.hori_rect);
			} else if (draw.equals("Vertical")) {
				imageView.setImageResource(R.drawable.vert_rect);
			} else {
				imageView.setImageResource(R.drawable.square_with_number);
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