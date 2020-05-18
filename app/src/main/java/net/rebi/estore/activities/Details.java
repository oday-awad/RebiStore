package net.rebi.estore.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.adapters.SectionsPagerAdapter;
import net.rebi.estore.classes.items_class;


public class Details extends AppCompatActivity {

//    FragmentManager     fragmentManager;
//    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.details );
        getWindow ( ).addFlags ( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );

        Intent      intent = getIntent ( );
        items_class item   = ( items_class ) intent.getSerializableExtra ( "selected_item" );

        new MyTask ().execute ( item );
        System.err.println ("oday awad" );
    }


    public void openSectionActivity ( String id ) {
        Intent intent = new Intent ( this , Sections.class );
        intent.putExtra ( "id" , id );
        startActivity ( intent );
    }

    class MyTask extends AsyncTask<items_class ,Integer , SectionsPagerAdapter>{

        @Override
        protected SectionsPagerAdapter doInBackground ( items_class... strings ) {


            return new SectionsPagerAdapter ( getBaseContext () , getSupportFragmentManager ( ) , strings[0] ,
                                      new OnItemsRecyclerViewClickListener ( ) {
                                           @Override
                                           public void onItemClick ( String id ) {
                                               openSectionActivity ( id );
                                           }

                                           @Override
                                           public void onItemClick ( items_class selected_item ) {

                                           }
                                       } );
        }

        @Override
        protected void onPostExecute ( SectionsPagerAdapter aVoid ) {

            ViewPager viewPager = findViewById ( R.id.view_pager );
            viewPager.setAdapter ( aVoid );
            TabLayout tabs = findViewById ( R.id.tabs );
            tabs.setupWithViewPager ( viewPager );

            super.onPostExecute ( aVoid );
        }
    }
}