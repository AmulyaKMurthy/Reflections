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


public class GraphTheory extends Fragment {

    Button good, average, excellent, good1, average1, excellent1, good2, average2, excellent2;
    int rating;
    String userusn, subject;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.gt, container, false);
        good = (Button) view.findViewById(R.id.gtgood);
        average = (Button) view.findViewById(R.id.gtavg);
        excellent = (Button) view.findViewById(R.id.gtexcellent);
        good1 = (Button) view.findViewById(R.id.gtgood1);
        average1 = (Button) view.findViewById(R.id.gtavg1);
        excellent1 = (Button) view.findViewById(R.id.gtexcellent1);
        good2 = (Button) view.findViewById(R.id.gtgood2);
        average2 = (Button) view.findViewById(R.id.gtavg2);
        excellent2 = (Button) view.findViewById(R.id.gtexcellent2);
        userusn = getArguments().getString("usn");

        good.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "g1";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field1 inserted");
            }

        });

        average.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "g1";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field1 inserted");
            }

        });
        excellent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "g1";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field1 inserted");
            }

        });

        good1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "g2";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field2 inserted");
            }

        });

        average1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "g2";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field2 inserted");
            }

        });
        excellent1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "g2";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field2 inserted");
            }

        });
        good2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 1;
                subject = "g3";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field3 inserted");
            }

        });

        average2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 2;
                subject = "g3";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field3 inserted");
            }

        });
        excellent2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                rating = 3;
                subject = "g3";
                add(rating, subject);
                Log.d("Database Operations", "Gt Field3 inserted");
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
                    Log.d("gt", "Retrieved " + StudList.size() + " student");
                    for (ParseObject student : StudList) {
                        if(RATING == 1)
                            rate = "good";
                        else if(RATING == 2)
                            rate = "average";
                        else
                            rate = "excellent";
                        switch(SUBJECT) {
                            case "g1": student.put("GtField1", rate);
                                break;
                            case "g2":student.put("GtField2", rate);
                                break;
                            case "g3":student.put("GtField3", rate);
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
