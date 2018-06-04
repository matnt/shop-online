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
import de.greenrobot.event.EventBus;

public class Phone_fragment extends Fragment{
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
        View view =  inflater.inflate(R.layout.fragment_phone, container, false);

        MyAsyncTask phone = new MyAsyncTask(view.getContext());
        ArrayList<Product> arrPhone = new ArrayList<Product>();
        try {
            arrPhone = phone.execute(1).get();
            recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            adapter = new CustomProductAdapter(arrPhone);
            recyclerView.setAdapter(adapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return view;
    }


}
