package com.skywalkr.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.skywalkr.fragments.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp=(ViewPager) findViewById(R.id.v_pager);
        FragmentManager fm=getSupportFragmentManager();
        FragmentPagerAdapter fpa=new MyPagerAdapter(fm);

        vp.setAdapter(fpa);
        TabLayout t=(TabLayout) findViewById(R.id.tview);
        t.setupWithViewPager(vp);

    }

    static class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int pos) {
            if (pos == 0) {
                return Frag_Page1.newInstance();
            } else if (pos == 1) {
                return Frag_Page2.newInstance();
            }
            return null;
        }


        @Override
        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int pos) {
            switch (pos) {
                case 0:
                    return "Fragment 1";
                case 1:
                    return "Fragment 2";
                default:
                    return null;
            }
        }
    }
}