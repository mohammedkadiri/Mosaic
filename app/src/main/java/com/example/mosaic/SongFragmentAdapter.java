package com.example.mosaic;


import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * A simple {@link Fragment} subclass.v
 */
public class SongFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    private final int NUM_PAGE = 3;

    public SongFragmentAdapter(FragmentManager fm, android.content.Context context) {
        // Required empty public constructor
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return NUM_PAGE;
    }

    @Override
    public Fragment getItem(int position) {
       switch(position){
           case 0:
               return new SongFragment();
           case 1:
              return new FavouriteFragment();
           case 2:
            return new PlaylistFragment();
       }
       return null;
    }


}
