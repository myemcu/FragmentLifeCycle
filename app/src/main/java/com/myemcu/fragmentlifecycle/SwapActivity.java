package com.myemcu.fragmentlifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SwapActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ContactFragment contact ;
    private DetailFragment  detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        // 创建分区管理对象
         fragmentManager = getSupportFragmentManager();
        // 创建联系人列表分区对象
         contact = ContactFragment.newInstance("a","b");
        // 创建联系人信息分区对象
         detail = DetailFragment.newInstance("a","b");
        //
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.add(R.id.fragment_container, contact);
        trans.commit();
    }

    public void btn_Swap(View view) {
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.fragment_container, detail);
        trans.addToBackStack(null);
        trans.commit();
    }
}
