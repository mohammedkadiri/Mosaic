package com.example.mosaic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HorizontalRecyclerViewAdapter extends  RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> sNames = new ArrayList<>();
    private ArrayList<String> sImage = new ArrayList<>();
    private Context sContext;


    public HorizontalRecyclerViewAdapter(Context context, ArrayList<String> names, ArrayList<String> images){
        sNames = names;
        sImage = images;
        sContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recentitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(sContext).asBitmap().load(sImage.get(position)).into(holder.image);
        holder.songName.setText(sNames.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Onclick: clicked on an image: " + sNames.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView songName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            songName = itemView.findViewById(R.id.songName);
        }
    }

}
