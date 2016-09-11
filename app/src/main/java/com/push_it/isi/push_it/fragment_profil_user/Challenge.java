package com.push_it.isi.push_it.fragment_profil_user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.viewChallenge.ChallengeTitreDescriptionActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Challenge.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Challenge#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Challenge extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Challenge() {
        // Required empty public constructor
    }


    ListAdapter challengeAdapt;
    Context ctx;
    Intent selectedItem;
    ListView listChallenge;
    TextView tv;
    LinearLayout ll;
    ArrayList<com.push_it.isi.push_it.entities.Challenge> arrayChallenge = new ArrayList<>();
    ArrayList<String> nomImage = new ArrayList<>();


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Challenge.
     */
    // TODO: Rename and change types and number of parameters
    public static Challenge newInstance(String param1, String param2) {
        Challenge fragment = new Challenge();
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
        // Inflate the layout for this fragment
        View vueChallenge =  inflater.inflate(R.layout.fragment_challenge, container, false);

        ctx = getContext();


        ll = new LinearLayout(getContext());
        ll.setBackgroundColor(Color.BLACK);

        tv = new TextView(getContext());
        tv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setText("Liste des Challenges");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(40);
        tv.setTextColor(Color.WHITE);


        listChallenge = (ListView) vueChallenge.findViewById(R.id.listeViewChallenge);

        String[] listDesChallenge = getResources().getStringArray(R.array.listChallenge);
        String[] listDesDescription = getResources().getStringArray(R.array.listeDescription);
        challengeAdapt = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listDesChallenge);

        for(int i = 0; i < 10; i++) {

            com.push_it.isi.push_it.entities.Challenge challenge = new com.push_it.isi.push_it.entities.Challenge(listDesChallenge[i],listDesDescription[i]);

            arrayChallenge.add(challenge);
        }

        Field[] fs = R.drawable.class.getFields();

        for(Field f : fs) {
            if (f.getName().equals("onehandpushup")) {
                Log.d("debug", f.getName().toString());
                try {
                    Log.d("debug", "Valeur de la ressources : "+f.getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


        listChallenge.setAdapter(challengeAdapt);

        listChallenge.addHeaderView(tv);

        listChallenge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 1:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(0).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(0).getDescription());
                        selectedItem.putExtra("numeroChallenge", "un");
                        startActivity(selectedItem);
                        break;
                    case 2:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(1).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(1).getDescription());
                        selectedItem.putExtra("numeroChallenge", "deux");
                        startActivity(selectedItem);
                        break;
                    case 3:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(2).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(2).getDescription());
                        selectedItem.putExtra("numeroChallenge", "trois");
                        startActivity(selectedItem);
                        break;
                    case 4:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(3).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(3).getDescription());
                        selectedItem.putExtra("numeroChallenge", "quatre");
                        startActivity(selectedItem);
                        break;
                    case 5:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(4).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(4).getDescription());
                        selectedItem.putExtra("numeroChallenge", "cinq");
                        startActivity(selectedItem);
                        break;
                    case 6:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(5).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(5).getDescription());
                        selectedItem.putExtra("numeroChallenge", "six");
                        startActivity(selectedItem);
                        break;
                    case 7:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(6).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(6).getDescription());
                        selectedItem.putExtra("numeroChallenge", "sept");
                        startActivity(selectedItem);
                        break;
                    case 8:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(7).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(7).getDescription());
                        selectedItem.putExtra("numeroChallenge", "huit");
                        startActivity(selectedItem);
                        break;
                    case 9:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(8).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(8).getDescription());
                        selectedItem.putExtra("numeroChallenge", "neuf");
                        startActivity(selectedItem);
                        break;
                    case 10:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(9).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(9).getDescription());
                        selectedItem.putExtra("numeroChallenge", "dix");
                        startActivity(selectedItem);
                        break;
                    case 11:
                        selectedItem = new Intent(ctx, ChallengeTitreDescriptionActivity.class);
                        selectedItem.putExtra("titre", arrayChallenge.get(0).getTitre());
                        selectedItem.putExtra("description", arrayChallenge.get(0).getDescription());
                        startActivity(selectedItem);
                        break;
                }

            }

        });




        return vueChallenge;
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
