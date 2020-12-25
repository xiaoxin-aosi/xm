package com.example.xm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xm.R;
import com.example.xm.view.fragment.ClassifyFragment;
import com.example.xm.view.fragment.MyFragment;
import com.example.xm.view.fragment.ShopFragment;
import com.example.xm.view.fragment.ShowFragment;
import com.example.xm.view.fragment.SubjectFragment;


public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;
    private RadioGroup rg;
    private RadioButton bt;
    private RadioButton bt2;
    private RadioButton bt3;
    private RadioButton bt4;
    private RadioButton bt5;
    private FragmentTransaction transaction;
    private ShowFragment showFragment;
    private SubjectFragment subjectFragment;
    private ClassifyFragment classifyFragment;
    private ShopFragment shopFragment;
    private MyFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);
        bt = findViewById(R.id.bt);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        transaction = getSupportFragmentManager().beginTransaction();
         showFragment = new ShowFragment();
        subjectFragment = new SubjectFragment();
        classifyFragment = new ClassifyFragment();
        shopFragment = new ShopFragment();
        myFragment = new MyFragment();
        transaction.add(R.id.fl, showFragment)
                .add(R.id.fl, subjectFragment)
                .add(R.id.fl, classifyFragment)
                .add(R.id.fl, shopFragment)
                .add(R.id.fl, myFragment)
                .hide(subjectFragment)
                .hide(classifyFragment)
                .hide(shopFragment)
                .hide(myFragment)
                .commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt:
                        getSupportFragmentManager().beginTransaction()
                                .show(showFragment)
                                .hide(subjectFragment)
                                .hide(classifyFragment)
                                .hide(shopFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.bt2:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .show(subjectFragment)
                                .hide(classifyFragment)
                                .hide(shopFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.bt3:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .show(classifyFragment)
                                .hide(shopFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.bt4:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .hide(classifyFragment)
                                .show(shopFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.bt5:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(subjectFragment)
                                .hide(classifyFragment)
                                .hide(shopFragment)
                                .show(myFragment)
                                .commit();
                        break;
                }
            }
        });
    }
}