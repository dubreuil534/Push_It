package com.push_it.isi.push_it.fragment_profil_user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.push_it.isi.push_it.bdamanager.UsagerManager;
import com.push_it.isi.push_it.entities.Usager;
import com.push_it.isi.push_it.R;
import com.push_it.isi.push_it.entities.UserStatic;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Setting.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Setting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Setting extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Setting() {
        // Required empty public constructor
    }

    TextView tvEmail;
    TextView tvPseudo;
    TextView tvMdp;
    TextView tvObjectif;
    TextView tvSexe;
    TextView tvPushUp;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Setting.
     */
    // TODO: Rename and change types and number of parameters
    public static Setting newInstance(String param1, String param2) {
        Setting fragment = new Setting();
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

        View viewSetting = inflater.inflate(R.layout.fragment_setting, container, false);

        String pseudoSetting = getArguments().getString("setting");


        tvEmail = (TextView) viewSetting.findViewById(R.id.courrielSetting);
        tvPseudo = (TextView) viewSetting.findViewById(R.id.pseudoSetting);
        tvMdp = (TextView) viewSetting.findViewById(R.id.mdpSetting);
        tvObjectif = (TextView) viewSetting.findViewById(R.id.objectifSetting);
        tvSexe = (TextView) viewSetting.findViewById(R.id.sexeSetting);
        tvPushUp = (TextView) viewSetting.findViewById(R.id.nbPushSetting);

        Usager userSetting = new Usager();
        userSetting.setPseudo(pseudoSetting);

        Usager userRetourDataSetting = UsagerManager.getSearchUserSetting(userSetting, getActivity());


        Log.d("debug", (userRetourDataSetting.getObjectifPush_Up()+"information dans ussersetting"));

        tvEmail.setText(userRetourDataSetting.getEmail());
        tvPseudo.setText(userRetourDataSetting.getPseudo());
         tvMdp.setText(userRetourDataSetting.getMdp());
        tvObjectif.setText(""+userRetourDataSetting.getObjectifPush_Up());
        tvPushUp.setText(""+ UserStatic.usagerEnCour.getNbPush_Up());
         tvSexe.setText(userRetourDataSetting.getSexe());

        Log.d("debug",UserStatic.getNbPushUp()+"");



        return viewSetting;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
