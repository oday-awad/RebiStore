package net.rebi.estore.others;

import android.app.Activity;

import androidx.viewpager.widget.ViewPager;

import java.util.TimerTask;

public class SliderTimer extends TimerTask {
    private boolean   x = true;
    private ViewPager viewPager;
    private Activity  activity;
    private int       imagesLength;

    public SliderTimer ( ViewPager viewPager , Activity activity , int imagesLength ) {
        this.viewPager = viewPager;
        this.activity = activity;
        this.imagesLength = imagesLength;
    }

    @Override
    public void run ( ) {
        if ( activity == null ) {
            return;
        }
        activity.runOnUiThread ( new Runnable ( ) {
            @Override
            public void run ( ) {
                if ( viewPager.getCurrentItem ( ) == 0 ) {
                    x = true;
                }
                if ( viewPager.getCurrentItem ( ) == imagesLength - 1 ) {
                    x = false;
                }
                if ( x ) {
                    viewPager.setCurrentItem ( viewPager.getCurrentItem ( ) + 1 );
                }
                else {
                    viewPager.setCurrentItem ( viewPager.getCurrentItem ( ) - 1 );
                }
            }
        } );
    }
}