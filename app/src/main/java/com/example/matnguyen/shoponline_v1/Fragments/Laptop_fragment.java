package com.example.matnguyen.shoponline_v1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matnguyen.shoponline_v1.Adapter.CustomProductAdapter;
import com.example.matnguyen.shoponline_v1.Controller.MyAsyncTask;
import com.example.matnguyen.shoponline_v1.Model.Product;
import com.example.matnguyen.shoponline_v1.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Laptop_fragment extends Fragment {
    private static RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_laptop, container, false);

        MyAsyncTask latop = new MyAsyncTask(view.getContext());
        ArrayList<Product> arrLaptop = new ArrayList<Product>();
        try {
            arrLaptop = latop.execute(3).get();
            recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view_laptop);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            adapter = new CustomProductAdapter(arrLaptop);
            recyclerView.setAdapter(adapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return view;
    }


}
