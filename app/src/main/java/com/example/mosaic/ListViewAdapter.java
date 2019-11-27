package com.example.mosaic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListViewAdapter  extends ArrayAdapter<String> {

    private Context context;
    String[] titles;
    String[] descriptions;
    int image;

    ListViewAdapter(Context c, String[] titles, int image, String[] descriptions){
        super(c, R.layout.single_row, R.id.titles, titles);
        context = c;
        this.titles = titles;
        this.image = image;
        this.descriptions = descriptions;

    }


    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);

        ImageView myImage  = row.findViewById(R.id.imageView);
        TextView myTitle = row.findViewById(R.id.titles);
        TextView myDescription = row.findViewById(R.id.description);

        myImage.setImageResource(image);
        myTitle.setText(titles[position]);
        myDescription.setText(descriptions[position]);

        return row;
    }
}
