package net.rebi.estore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import net.rebi.estore.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context   context;
    private Integer[] images;

    public ViewPagerAdapter ( Context context , Integer[] images ) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount ( ) {
        return images.length;
    }

    @Override
    public boolean isViewFromObject ( View view , Object object ) {
        return view == object;
    }

    @Override
    public Object instantiateItem ( ViewGroup container , final int position ) {

        LayoutInflater layoutInflater =
                ( LayoutInflater ) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        View      view             = layoutInflater.inflate ( R.layout.slider_layout , null );
        ImageView slider_imageView = view.findViewById ( R.id.slider_imageView );
        slider_imageView.setImageResource ( images[ position ] );
        ViewPager vp = ( ViewPager ) container;
        vp.addView ( view , 0 );
        return view;

    }

    @Override
    public void destroyItem ( ViewGroup container , int position , Object object ) {

        ViewPager vp   = ( ViewPager ) container;
        View      view = ( View ) object;
        vp.removeView ( view );

    }


}

