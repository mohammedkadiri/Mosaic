package com.example.mosaic;


import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment {
    private ArrayList<String> sNames = new ArrayList<>();
    private ArrayList<String> sImage = new ArrayList<>();
    String[] songTitles = {"Rihanna - Disturbia", "Chris Brown - Blow  my mind", "Sean Paul - Gimme the light", "Rihanna - Disturbia", "Chris Brown - Blow  my mind", "Sean Paul - Gimme the light","Rihanna - Disturbia", "Chris Brown - Blow  my mind", "Sean Paul - Gimme the light"};
    String[] songArtist = {"Rihanna | Unknown album", "Chris Brown", "Sean Paul", "Rihanna | Unknown album", "Chris Brown", "Sean Paul", "Rihanna | Unknown album", "Chris Brown", "Sean Paul"};
    int images = R.drawable.rinnegan;

    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.horizon_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        getImageViews();
        HorizontalRecyclerViewAdapter adapter = new HorizontalRecyclerViewAdapter(getActivity(), sNames, sImage);
        recyclerView.setAdapter(adapter);

        ListViewAdapter ladapter = new ListViewAdapter(getActivity(), songTitles, images, songArtist);
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(ladapter);

        return view;
    }

    private void getImageViews(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        sImage.add("https://img.quizur.com/f/img5c884840a62cc9.48055575.jpg?lastEdited=1552435268");
        sNames.add("Rihanna - Disturbia");

        sImage.add("https://vignette.wikia.nocookie.net/war-of-east-hunter-x-hunter/images/2/2d/Gon_Freecss.png/revision/latest?cb=20190811191852");
        sNames.add("Headie One - Both");

        sImage.add("http://www.anime-evo.net/wp-content/uploads/2017/04/Boku2_02_10.jpg");
        sNames.add("YNW MELLY - Mama Cry");

        sImage.add("http://images6.fanpop.com/image/photos/32500000/tobi-uchiha-obito-32599615-1280-720.jpg");
        sNames.add("Rema - Why(Unofficial Video)");


        sImage.add("https://pbs.twimg.com/profile_images/1687947443/op1.jpg");
        sNames.add("Dave X AJ Tracey - Thiago Silva");
    }

}
