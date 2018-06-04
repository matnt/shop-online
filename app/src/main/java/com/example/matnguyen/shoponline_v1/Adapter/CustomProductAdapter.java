package com.example.matnguyen.shoponline_v1.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matnguyen.shoponline_v1.Controller.Config;
import com.example.matnguyen.shoponline_v1.Model.Product;
import com.example.matnguyen.shoponline_v1.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CustomProductAdapter extends RecyclerView.Adapter<CustomProductAdapter.MyViewHolder> {
    private ArrayList<Product> dataSet;
    //Context context;

    public CustomProductAdapter(ArrayList<Product> products){
        this.dataSet = products;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDetail;
        ImageView imageViewIcon;
        Button btnAdd;

        public MyViewHolder(View itemView){
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.textView13);
            this.tvDetail = (TextView) itemView.findViewById(R.id.textView14);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            this.btnAdd = (Button) itemView.findViewById(R.id.button4);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_fragment, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        TextView tvName = holder.tvName;
        TextView tvDetail = holder.tvDetail;
        ImageView image = holder.imageViewIcon;
        Button btnAdd = holder.btnAdd;

        Product p = dataSet.get(position);
        tvName.setText(p.getName());
        tvDetail.setText(p.getDescription());
        try {
            //System.out.println("URL IMAGE: " + Config.URL_CONNECT + p.getImage());
            String s = Config.URL_CONNECT + p.getImage();
            System.out.println(s + " ");
            URL url_image = new URL(p.getImage());
            Bitmap bmp = BitmapFactory.decodeStream(url_image.openConnection().getInputStream());
            image.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Phone_fragment.data.add()
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = dataSet.get(position);
                String message = "Tên sản phẩm: " + p.getName() + "\nGiá: " + p.getPrice() + "\nThông tin chi tiết: " + p.getDescription();
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();
                alertDialog.setTitle("Detail");
                alertDialog.setMessage(message);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();

    }
}
