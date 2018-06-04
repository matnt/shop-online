package com.example.matnguyen.shoponline_v1.Fragments;


import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.matnguyen.shoponline_v1.Model.User;
import com.example.matnguyen.shoponline_v1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class User_fragment extends Fragment {
    EditText  edtName;
    EditText edtEmail;
    EditText edtSDT;
    EditText edtNS;
    EditText edtDiaChi;
    RadioGroup rdGroup;
    Button btnUpdate;
    ImageButton btnDate;
    String name;
    String email;
    String sdt;
    String dia_chi;
    Date ngay_sinh;
    Boolean gender;
    Calendar c;


    public User_fragment() {

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_fragment_layout, container, false);

        initWideget(view);
        capNhatThongTin();
        setDefaultInfo();

        return view;
    }

    public void initWideget(View view){
        edtName = view.findViewById(R.id.textView9);
        edtEmail = view.findViewById(R.id.editText6);
        edtSDT = view.findViewById(R.id.editText8);
        edtNS = view.findViewById(R.id.editText5);
        edtDiaChi = view.findViewById(R.id.editText9);
        rdGroup = view.findViewById(R.id.radioGroup);
        btnUpdate = view.findViewById(R.id.button3);
        btnDate = view.findViewById(R.id.imageButton);

    }
    public void capNhatThongTin(){
        name = edtName.getText().toString();
        sdt = edtSDT.getText().toString();
        email = edtEmail.getText().toString();
        dia_chi = edtDiaChi.getText().toString();

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton)
                    gender = false;
                if(checkedId == R.id.radioButton2)
                    gender = true;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user3 = new User(name, gender, email, ngay_sinh, sdt);
                // api update dữ liệu lên server

            }
        });
    }


    public void setDefaultInfo(){
        c = Calendar.getInstance();
        SimpleDateFormat dft = null;

        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(c.getTime());
        edtNS.setText(strDate);
        ngay_sinh = c.getTime();

    }

    public void showDatePickerDialog(){
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                edtNS.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                c.set(year, monthOfYear, dayOfMonth);
                ngay_sinh = c.getTime();

            }
        };

        String s = edtNS.getText()+ "";
        // cắt các ký hiệu / trong xâu s
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]) - 1;
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic = new DatePickerDialog(getContext(), 0, callBack, nam, thang, ngay);
        pic.show();
    }

}
