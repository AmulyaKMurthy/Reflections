package com.amulya.murthy.reflections12;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by abc on 7/4/2015.
 */
public class Mathematics extends Fragment {
    Button good,average,excellent,good1,average1,excellent1,good2,average2,excellent2;
    int rating;
    String userusn,subject;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.math, container, false);
        good = (Button)view.findViewById(R.id.mgood);
        average = (Button)view.findViewById(R.id.mavg);
        excellent = (Button)view.findViewById(R.id.mexcellent);
        good1 = (Button)view.findViewById(R.id.mgood1);
        average1 = (Button)view.findViewById(R.id.mavg1);
        excellent1 = (Button)view.findViewById(R.id.mexcellent1);
        good2 = (Button)view.findViewById(R.id.mgood2);
        average2 = (Button)view.findViewById(R.id.mavg2);
        excellent2 = (Button)view.findViewById(R.id.mexcellent2);
        userusn = getArguments().getString("usn");
        good.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {


                rating = 1;
                subject = "m1";
                add(rating,subject);
                Log.d("Database Operations", "Math Field1 inserted");
            }

        });

        average.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "m1";
                add(rating,subject);
                Log.d("Database Operations", "Math Field1 inserted");
            }

        });
        excellent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "m1";
                add(rating, subject);
                Log.d("Database Operations", "Math Field1 inserted");
            }

        });

        good1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "m2";
                add(rating,subject);
                Log.d("Database Operations", "Math Field2 inserted");
            }

        });

        average1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "m2";
                add(rating,subject);
                Log.d("Database Operations", "Math Field2 inserted");
            }

        });
        excellent1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "m2";
                add(rating,subject);
                Log.d("Database Operations", "Math Field2 inserted");
            }

        });
        good2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "m3";
                add(rating,subject);
                Log.d("Database Operations", "Math Field3 inserted");
            }

        });

        average2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "m3";
                add(rating,subject);
                Log.d("Database Operations", "Math Field3 inserted");
            }

        });
        excellent2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "m3";
                add(rating,subject);
                Log.d("Database Operations", "Math Field3 inserted");
            }

        });
        return view;
    }

    public void add(final int RATING,final String SUBJECT)
    {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("StudentDatabase");
        query.whereEqualTo("usn",userusn);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> StudList, ParseException e) {

                if (e == null) {
                    String rate = "";
                    Log.d("math", "Retrieved " + StudList.size() + " student");
                    for (ParseObject student : StudList) {
                        if(RATING == 1)
                            rate = "good";
                        else if(RATING == 2)
                            rate = "average";
                        else
                            rate = "excellent";
                        switch(SUBJECT) {
                            case "m1": student.put("MathField1", rate);
                                break;
                            case "m2":student.put("MathField2", rate);
                                break;
                            case "m3":student.put("MathField3", rate);
                                break;
                        }
                        student.saveInBackground();
                        Toast.makeText(getActivity().getBaseContext(), "Rating is recorded.", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}
