package com.example.matnguyen.shoponline_v1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matnguyen.shoponline_v1.Fragments.GioHang_fragment;
import com.example.matnguyen.shoponline_v1.Model.Product;
import com.example.matnguyen.shoponline_v1.R;

import java.util.ArrayList;

public class CustomListviewAdapter extends ArrayAdapter<Product>{
    private ArrayList<Product> dataSet;
    private Context context;


    private class ViewHolder {
        TextView tvName;
        TextView tvPrice;
        EditText soluong;
        Button btnDelete;
    }

    public CustomListviewAdapter( Context context, ArrayList<Product> data){
        super(context, R.layout.custom_list_view, data);
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.textView23);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.textView25);
            viewHolder.soluong = (EditText) convertView.findViewById(R.id.editText7);
            viewHolder.btnDelete = (Button) convertView.findViewById(R.id.button7);

        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Product product = dataSet.get(position);
        viewHolder.tvName.setText(product.getName());
        viewHolder.tvPrice.setText(product.getPrice() + "");
        int nums = Integer.parseInt (viewHolder.soluong.getText().toString());
        GioHang_fragment.totalPrice += nums * product.getPrice();
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer index = (Integer) v.getTag();
                dataSet.remove(index.intValue());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

}
