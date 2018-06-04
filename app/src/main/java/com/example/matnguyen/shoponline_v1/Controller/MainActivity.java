package com.example.matnguyen.shoponline_v1.Controller;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.matnguyen.shoponline_v1.Adapter.ViewPagerAdapter;
import com.example.matnguyen.shoponline_v1.Fragments.GioHang_fragment;
import com.example.matnguyen.shoponline_v1.Fragments.Home_fragment;
import com.example.matnguyen.shoponline_v1.Fragments.User_fragment;
import com.example.matnguyen.shoponline_v1.Model.Product;
import com.example.matnguyen.shoponline_v1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWideget();
        setupViewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    public void initWideget(){
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
    }

    public void setupViewpager(ViewPager view){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_fragment(), "Home");
        adapter.addFragment(new GioHang_fragment(), "Giỏ hàng");
        adapter.addFragment(new User_fragment(), "User");
        view.setAdapter(adapter);
    }

    public void setupTabIcons(){

        TextView tabHome = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
        //tabHome.setText("Home");
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_32, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabHome);

        TextView tabCart = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
        //tabCart.setText("Giỏ hàng");
        tabCart.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cart_32, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabCart);

        TextView tabUser = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
        //tabUser.setText("User");
        tabUser.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.user_32, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabUser);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:

                break;
            case R.id.about:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("About project!").setMessage("Phần mềm này được thiết kế bởi team BTL Lập trình nâng cao").setIcon(android.R.drawable.ic_dialog_info).show();
                break;
        }
        return true;
    }



}

