package com.phuoc.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager2);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);
        radioGroup3 = findViewById(R.id.radio_group_3);

        radioGroup1.check(R.id.rdb_ltr);
        radioGroup2.check(R.id.rdb_horizontal);
        radioGroup3.check(R.id.rdb_normal);

        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rdb_ltr) {
                    viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                } else if (i == R.id.rdb_rtl) {
                    viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rdb_vertical) {
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                } else if (i == R.id.rdb_horizontal) {
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rdb_normal) {
                    viewPager2.setPageTransformer(null);
                } else if (i == R.id.rdb_zoom) {
                    viewPager2.setPageTransformer(new ZoomOutPageTransformer());
                } else if (i == R.id.rdb_depth) {
                    viewPager2.setPageTransformer(new DepthPageTransformer());
                }
            }
        });
    }
}