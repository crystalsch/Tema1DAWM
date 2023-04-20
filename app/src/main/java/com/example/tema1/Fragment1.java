package com.example.tema1;

import static java.util.Arrays.asList;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class Fragment1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView animalsListView;
    static ArrayAdapter<String> arrayAdapter;
    SharedPreferences sharedPreferences;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animalsListView = (ListView)view.findViewById(R.id.animals_list_view);

        ArrayList<AnimalModel> animals = new ArrayList<>(Arrays.asList(
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Europa"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "Asia"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "America"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Africa"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia"),
                new AnimalModel("Rinocer", "Australia")
        ));


        ArrayList <String> animalsData = new ArrayList<String>();
        for(int index = 0; index< animals.size(); index++)
        {
            animalsData.add(animals.get(index).displayAnimal());
        }
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, animalsData);
        animalsListView.setAdapter(arrayAdapter);

        animalsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity =(MainActivity)getActivity();
                sharedPreferences = mainActivity.getApplicationContext().getSharedPreferences("com.example.tema1", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("animal", animals.get(i).getName()).apply();
                sharedPreferences.edit().putString("continent", animals.get(i).getContinent()).apply();
                replaceFragment(new Fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();//getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.i("change", "ok");
    }
}
