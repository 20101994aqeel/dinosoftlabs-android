package com.example.testproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    ImageView image_one , image_two ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_one = findViewById(R.id.image_one);
        image_two = findViewById(R.id.image_two);

        findViewByID();
    }

        private void findViewByID() {

            viewPager = (ViewPager) findViewById(R.id.viewpager);
            FragmentManager fragmentManager=getSupportFragmentManager();
            viewPager.setAdapter(new PagerAdapter(fragmentManager));
//            viewPager.beginFakeDrag();

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                }

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onPageSelected(int position) {

                    if (position == 0 ){
                        Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                        image_one.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.paypal_background_btn) );
                    }
                    else {
                        image_one.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.color.white) );
                    }


                    if (position == 1 ){
                        Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                        image_two.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.paypal_background_btn) );
                    }
                    else {
                        image_two.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.color.white) );
                    }



                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


            image_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fragment_one fragment_one = new  Fragment_one();
                    FragmentManager fm =getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    image_one.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.paypal_background_btn) );
                    image_two.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.color.white) );
                    ft.replace(R.id.fragment_two, fragment_one).addToBackStack(null).commit();

                    Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
                }
            });

            image_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fragment_Two fragment_two = new Fragment_Two();
                    FragmentManager fm1 =getSupportFragmentManager();
                    FragmentTransaction ft1 = fm1.beginTransaction();
                    image_two.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.paypal_background_btn) );
                    image_one.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.color.white) );
                    ft1.replace(R.id.fragment_one, fragment_two).addToBackStack(null).commit();


                    Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();

                }
            });
        }



}
