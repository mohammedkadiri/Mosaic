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

        // ListView optimization to recycle views as the layout inflation process is expensive
        View row = convertView;
        MyViewHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        }
        else {
            holder = (MyViewHolder)row.getTag();
        }

        holder.myImage.setImageResource(image);
        holder.myTitle.setText(titles[position]);
        holder.myDescription.setText(descriptions[position]);

        return row;
    }
}

class MyViewHolder {

    ImageView myImage;
    TextView myTitle;
    TextView myDescription;

    MyViewHolder(View v){
        myImage = v.findViewById(R.id.imageView);
        myTitle = v.findViewById(R.id.titles);
        myDescription = v.findViewById(R.id.description);
    }
}
