package com.example.matnguyen.shoponline_v1.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matnguyen.shoponline_v1.Adapter.CustomListviewAdapter;
import com.example.matnguyen.shoponline_v1.Model.Product;
import com.example.matnguyen.shoponline_v1.R;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

public class GioHang_fragment  extends Fragment {
    public static int totalPrice;

    public GioHang_fragment() {

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.gio_hang_fragment_layout, container, false);

        TextView tvName = (TextView) view.findViewById(R.id.textView16);
        tvName.setText("");
        TextView tvPrice = (TextView) view.findViewById(R.id.textView22);
        tvPrice.setText(totalPrice + "");
        Button btnKM = (Button) view.findViewById(R.id.button5);
        btnKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code ap dung khuyen mai


            }
        });
        Button btnThanhtoan = (Button) view.findViewById(R.id.button6);
        btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check neu dang nhap roi thi nhay vao trang thanh toan
                // neu k dang nhap thi hien thi vao trang dang nhap, dang ky



            }
        });
        ListView listView = (ListView) view.findViewById(R.id.listview);

        //EventBus.getDefault().registerSticky(this);
        //Product product = new Product(); // = getValue........ from phone, tablet, laptop, phukien fragment

        //ArrayList<Product> arrayList = new ArrayList<Product>();
        //arrayList.add(product);

        //CustomListviewAdapter customListviewAdapter = new CustomListviewAdapter(view.getContext(), arrayList);
        //listView.setAdapter(customListviewAdapter);
        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
