package com.cmauroie.skyforecasttest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HeadFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HeadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeadFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM_COUNTRY = "param_country";
    private static final String ARG_PARAM_DATE = "param_date";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParamCountry;

    //private OnFragmentInteractionListener mListener;

    private TextView temperature;
    private ImageView imageTemperature;
    private TextView country;
    private TextView date;
    private ImageView imageCountry;
    private String mParamDate;

    public HeadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param date
     * @return A new instance of fragment HeadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeadFragment newInstance(String param1, String param2, String country, String date) {
        HeadFragment fragment = new HeadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM_COUNTRY, country);
        args.putString(ARG_PARAM_DATE, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParamCountry = getArguments().getString(ARG_PARAM_COUNTRY);
            mParamDate = getArguments().getString(ARG_PARAM_DATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_head, container, false);
        temperature = (TextView) view.findViewById(R.id.temperature);
        imageTemperature = (ImageView) view.findViewById(R.id.icon_temperature);
        country = (TextView) view.findViewById(R.id.country);
        date = (TextView) view.findViewById(R.id.date);
        imageCountry = (ImageView) view.findViewById(R.id.icon_country);

        if (mParam1 != null) {
            temperature.setText(mParam1 + "°");
            date.setText(mParamDate);
            country.setText(mParamCountry);

            if (mParam2.equals("clear-night") || mParam2.equals("partly-cloudy-night")) {
                imageTemperature.setImageResource(R.drawable.icon_clear_night);
            }
            if(mParam2.equals("clear-day") || mParam2.equals("partly-cloudy-day")){
                imageTemperature.setImageResource(R.drawable.icon_clear_day);
            }
            if(mParam2.equals("rain")){
                imageTemperature.setImageResource(R.drawable.icon_rain);
            }
            if(mParam2.equals("snow")){
                imageTemperature.setImageResource(R.drawable.icon_snow);
            }
            if(mParam2.equals("sleet")){
                imageTemperature.setImageResource(R.drawable.icon_sleet);
            }
            if(mParam2.equals("wind")){
                imageTemperature.setImageResource(R.drawable.icon_air);
            }
            if(mParam2.equals("fog")){
                imageTemperature.setImageResource(R.drawable.icon_fog);
            }
            if(mParam2.equals("cloudy")){
                imageTemperature.setImageResource(R.drawable.icon_cloudy);
            }
        }

        String imageUrl = "http://lorempixel.com/400/310/city/" + mParamCountry.toLowerCase() + "/";
        Log.i("", "url imAGEEEEEEEEEEEEEEEEEE" + imageUrl);
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageCountry);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
