package com.amulya.murthy.reflections12;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;



public class PagerAdapter extends FragmentPagerAdapter {

    String userusn;

    public PagerAdapter(FragmentManager fm,String usn)
    {
        super(fm);
        this.userusn = usn;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Mathematics mathfrag = new Mathematics();
                Bundle bundle = new Bundle();
                bundle.putString("usn", userusn);
                mathfrag.setArguments(bundle);
                return mathfrag;
            case 1:
                GraphTheory gtfrag = new GraphTheory();
                Bundle bundle1 = new Bundle();
                bundle1.putString("usn",userusn);
                gtfrag.setArguments(bundle1);
                return gtfrag;
            case 2:
                Unix unixfrag = new Unix();
                Bundle bundle2 = new Bundle();
                bundle2.putString("usn",userusn);
                unixfrag.setArguments(bundle2);
                return unixfrag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
