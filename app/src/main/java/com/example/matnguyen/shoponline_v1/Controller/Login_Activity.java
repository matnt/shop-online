package com.example.matnguyen.shoponline_v1.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matnguyen.shoponline_v1.Model.User;
import com.example.matnguyen.shoponline_v1.R;

public class Login_Activity  extends Activity {

    EditText txtname;
    EditText txtpass;
    Button btnLogin;
    TextView txtCreateNewAcc;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initWideget();
        checkLogin();

    }

    public void initWideget(){
        txtname = findViewById(R.id.editText);
        txtpass = findViewById(R.id.editText2);
        btnLogin = findViewById(R.id.button);
        txtCreateNewAcc = findViewById(R.id.textView8);
    }

    public void checkLogin(){
        String name = txtname.getText().toString();
        int password = Integer.parseInt(txtpass.getText().toString());
        User user1 = new User(name, password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = false; //= check link
                if(result == true){

                } else {
                    Toast.makeText(Login_Activity.this, "Đăng nhập chưa thành công! Hãy thử lại", Toast.LENGTH_LONG).show();
                }

            }
        });

        txtCreateNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
