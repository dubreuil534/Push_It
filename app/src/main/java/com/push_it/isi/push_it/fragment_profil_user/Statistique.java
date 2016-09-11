package com.push_it.isi.push_it.fragment_profil_user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.push_it.isi.push_it.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Statistique.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Statistique#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Statistique extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Statistique() {
        // Required empty public constructor
    }

    BarChart barChart;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Statistique.
     */
    // TODO: Rename and change types and number of parameters
    public static Statistique newInstance(String param1, String param2) {
        Statistique fragment = new Statistique();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewStatistique =  inflater.inflate(R.layout.fragment_statistique, container, false);


        barChart = (BarChart) viewStatistique.findViewById(R.id.chart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(15f,0));
        barEntries.add(new BarEntry(25f,50));
        barEntries.add(new BarEntry(35f,20));
        barEntries.add(new BarEntry(45f,55));
        barEntries.add(new BarEntry(55f,80));
        barEntries.add(new BarEntry(65f,200));
        barEntries.add(new BarEntry(75f,5));


        BarDataSet barDataSet = new BarDataSet(barEntries,"Semaine");


        ArrayList<String> semaine = new ArrayList<>();
        semaine.add("Lundi");
        semaine.add("Mardi");
        semaine.add("Mercredi");
        semaine.add("Jeudi");
        semaine.add("Vendredi");
        semaine.add("Samedi");
        semaine.add("Dimanche");
        // ArrayList<String> mois = new ArrayList<>();
        //  ArrayList<String> annee = new ArrayList<>();

        BarData myData = new BarData(barDataSet);
        myData.setBarWidth(9f);
        barChart.setData(myData);
        barChart.setFitBars(true);
        barChart.invalidate();




        return viewStatistique;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
