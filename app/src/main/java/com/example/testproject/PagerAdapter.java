package com.example.testproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;
        if(i==0)
        {
            fragment = new Fragment_one();
        }

        if(i==1)
        {
            fragment = new Fragment_Two();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
