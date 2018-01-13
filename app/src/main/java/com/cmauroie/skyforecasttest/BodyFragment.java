package com.cmauroie.skyforecasttest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmauroie.skyforecasttest.adapter.DataAdapter;
import com.cmauroie.skyforecasttest.entities.Daily;
import com.cmauroie.skyforecasttest.entities.DataCell;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BodyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BodyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BodyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM_HUMIDITY = "param_humidity";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mHumidity;

    //private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerManager;

    public BodyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param humidity
     * @return A new instance of fragment BodyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BodyFragment newInstance(String param1, String param2, String humidity) {
        BodyFragment fragment = new BodyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM_HUMIDITY, humidity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mHumidity = getArguments().getString(ARG_PARAM_HUMIDITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_body, container, false);

        TextView textFlag = (TextView)v.findViewById(R.id.flag);
        TextView textCompass = (TextView)v.findViewById(R.id.compass);
        TextView textHumidity = (TextView)v.findViewById(R.id.humidity);

        DataCell data;
        List<DataCell> arrayList = new ArrayList<>();
        if (mParam1 != null) {
            Gson gson = new Gson();
            Daily daily = gson.fromJson(mParam1, Daily.class);

            for (int i = 0; i < daily.data.size()-3; i++) {
                data = new DataCell();
                data.day = getDay(i);
                data.icon = daily.data.get(i).icon;
                data.temp = daily.data.get(i).temperatureHigh;
                arrayList.add(data);
            }
            cellDaily(arrayList, v);

            textFlag.setText(mParam2 + " MPH");
            Double humidity = Double.parseDouble(mHumidity) * 100;
            DecimalFormat format = new DecimalFormat("0.#");

            textHumidity.setText(format.format(humidity) + "%");
            textCompass.setText("");

        }
        return v;
    }

    private String getDay(int day){
        String dayStr = "";
        switch (day){
            case 0:
                dayStr = "Lunes";
                break;
            case 1:
                dayStr = "Martes";
                break;
            case 2:
                dayStr = "Miercoles";
                break;
            case 3:
                dayStr = "Jueves";
                break;
            case 4:
                dayStr = "Viernes";
                break;
        }
        return dayStr;
    }

    private void cellDaily(List<DataCell> days, View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.id_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(recyclerManager);
        recyclerAdapter = new DataAdapter(days, getActivity());
        recyclerView.setAdapter(recyclerAdapter);
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
