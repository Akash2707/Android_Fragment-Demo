package com.example.aakash.fragmenttask;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements RedFragment.ActivityCommunicator {
    Button btn_red, btn_blue, btn_green;
    android.support.v4.app.Fragment f;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_red = findViewById(R.id.activity_main_btn_red);
        btn_blue = findViewById(R.id.activity_main_btn_blue);
        btn_green = findViewById(R.id.activity_main_btn_green);

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new RedFragment());
                mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });

        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new BlueFragment());
                mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });

        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final GreenFragment greenFragment = new GreenFragment();

                mFragmentManager = getSupportFragmentManager();
                final FragmentTransaction transaction = mFragmentManager.beginTransaction();
                transaction.add(R.id.container, greenFragment, greenFragment.getClass().getSimpleName());
                f = getSupportFragmentManager().findFragmentById(R.id.container);
                if (f != null) {
                    transaction.hide(f);
                    transaction.addToBackStack(greenFragment.getClass().getSimpleName());
                    transaction.commit();
                }
                else{
                    transaction.commit();
                }
            }
        });


    }

    public void replaceFragment(final Fragment fragment) {
        mFragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();

    }


    @Override
    public void passDatatoActivity(String value) {
        if (value.equalsIgnoreCase("Red")) {
            btn_red.setBackgroundColor(Color.parseColor("#ff0000"));
        }
        if (value.equalsIgnoreCase("Blue")) {
            btn_blue.setBackgroundColor(Color.parseColor("#0000ff"));
        }
        if(value.equalsIgnoreCase("Green")){
            btn_green.setBackgroundColor(Color.parseColor("#00ff00"));
        }
    }
}
