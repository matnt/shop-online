package com.example.matnguyen.shoponline_v1.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matnguyen.shoponline_v1.Model.User;
import com.example.matnguyen.shoponline_v1.R;

public class Register_Activity extends Activity {

    EditText txtname;
    EditText txtPassword;
    Button btnCreate;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_account_layout);
        initWidget();
        createAccount();

    }

    public void initWidget(){
        txtname = findViewById(R.id.editText3);
        txtPassword = findViewById(R.id.editText4);
        btnCreate = findViewById(R.id.button2);
    }
    public void createAccount(){
        String name = txtname.getText().toString();
        int password = Integer.parseInt(txtPassword.getText().toString());
        User user2 = new User(name, password);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = false; //= check link
                if(result){
                    // do something

                } else {
                    Toast.makeText(Register_Activity.this, "Tài khoản của bạn không hợp lệ hoặc đã tồn tại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
