package com.amulya.murthy.reflections12;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class Subjects extends FragmentActivity {
    ViewPager viewPager;
    String userusn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjects);
        Bundle b = getIntent().getExtras();
        userusn = b.getString("usn");
        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pAdapter = new PagerAdapter(getFragmentManager(),userusn);
        viewPager.setAdapter(pAdapter);
    }
}
