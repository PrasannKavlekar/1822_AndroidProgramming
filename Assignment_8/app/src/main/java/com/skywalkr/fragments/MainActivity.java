package com.skywalkr.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp=(ViewPager) findViewById(R.id.v_pager);        //ViewPager
        FragmentManager fm=getSupportFragmentManager();
        FragmentPagerAdapter fpa=new MyPagerAdapter(fm);

        Button btn = findViewById(R.id.loadbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u = new User();
                u.name = "Prasann";
                u.email = "prasannkavlekar9@gmail.com";
                u.phone = "7020168074";
                u.pass = "password";
                u.confpass = "password";

                u.sval = "Goa";
                u.dval = "North Goa";
                u.bval = "01-08-96";

                FrameLayout fl1 = findViewById(R.id.fpage1);                //FrameLayout
                FrameLayout fl2 = findViewById(R.id.fpage2);

                TextInputEditText name = fl1.findViewById(R.id.ntb);        //Fragment1
                TextInputEditText email = fl1.findViewById(R.id.etb);
                TextInputEditText phone = fl1.findViewById(R.id.ctb);
                TextInputEditText password = fl1.findViewById(R.id.ptb);
                TextInputEditText cpassword = fl1.findViewById(R.id.ptb1);

                MaterialToolbar mtool = fl2.findViewById(R.id.usernamebar); //Fragment2
                RadioButton mbtn = fl2.findViewById(R.id.malebtn);
                TextInputEditText state = fl2.findViewById(R.id.stb);
                TextInputEditText bday = fl2.findViewById(R.id.btb);
                MaterialSpinner district = fl2.findViewById(R.id.dtb);

                name.setText(u.name);                                       //SetText
                email.setText(u.email);
                phone.setText(u.phone);
                password.setText(u.pass);
                cpassword.setText(u.confpass);

                mtool.setTitle(u.name);
                mbtn.setChecked(true);
                state.setText(u.sval);
                district.setText(u.dval);
                bday.setText(u.bval);

            }
        });

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