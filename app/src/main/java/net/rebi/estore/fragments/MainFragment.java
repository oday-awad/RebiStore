package net.rebi.estore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import net.rebi.estore.AsyncTask.SectionsAsyncTask;
import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.adapters.SectionsRecyclerAdapter;
import net.rebi.estore.adapters.ViewPagerAdapter;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.others.SliderTimer;

import java.util.Timer;


public class MainFragment extends Fragment {


    private RecyclerView                     rv_sections;
    private SectionsRecyclerAdapter          sectionsRecyclerAdapter;
    private ViewPager                        viewPager;
    private OnItemsRecyclerViewClickListener listener;
    private NestedScrollView                 NestedScrollView;
    private ProgressBar                      progressBar;


    public MainFragment ( ) {
        // Required empty public constructor
    }

    public MainFragment ( OnItemsRecyclerViewClickListener listener ) {
        this.listener = listener;
    }


    @Override
    public View onCreateView (
            LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate ( R.layout.main_fragment , container , false );

        rv_sections = root.findViewById ( R.id.rv_sections );
        NestedScrollView = root.findViewById ( R.id.nested );
        progressBar = root.findViewById ( R.id.progressBar );


        //Start Getting data
        SectionsAsyncTask myTask =
                new SectionsAsyncTask ( getContext ( ) , sectionsRecyclerAdapter , rv_sections ,
                                        progressBar , new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {
                        listener.onItemClick ( id );
                    }

                    @Override
                    public void onItemClick ( items_class selected_item ) {
                        System.err.println ("  -     1      -   " );
                        listener.onItemClick ( selected_item );

                    }
                } );
        myTask.execute ( );
        //End Getting data


        //Start Getting The Slider Images
        //TODO Replace With String Array
        Integer[] images = { R.drawable.car , R.drawable.shopping , R.drawable.image1 };
        //End Getting The Slider Images


        //Start The Slider
        viewPager = root.findViewById ( R.id.viewPager );
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter ( getContext ( ) , images );
        viewPager.setAdapter ( viewPagerAdapter );
        //Auto Move The Slider
        Timer timer = new Timer ( );
        timer.scheduleAtFixedRate ( new SliderTimer ( viewPager , getActivity ( ) ,
                                                      images.length ) , 10000 , 5000 );
        //End The Slider


        return root;
    }


}
