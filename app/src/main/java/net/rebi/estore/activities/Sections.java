package net.rebi.estore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.adapters.ItemsRecyclerAdapter;
import net.rebi.estore.classes.items_class;

import java.util.ArrayList;
import java.util.Random;

public class Sections extends AppCompatActivity {

    private Integer[] images = { R.drawable.car , R.drawable.shopping , R.drawable.image1 };


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.sections );

        Intent intent = getIntent ();
        String id     = intent.getStringExtra ( "id" );


        RecyclerView rv_items               = findViewById ( R.id.section_rv_items );
        TextView     section_fragment_title = findViewById ( R.id.section_title );

        Random rand = new Random( images.length);

        //Start Getting Data

        String desc =
                "Lorem ipsum dolor sit amet consectetur elit. Aliquam asperiores commodi debitis "
                + "dolores eum excepturi magni mollitia, quaerat, quibusdam quos recusandae rem " + "sit vitae. Asperiores eveniet excepturi facilis quasi suscipit?Lorem ipsum dolor sit amet consectetur elit. Aliquam asperiores commodi debitis \"\n" + "                + \"dolores eum excepturi magni mollitia, quaerat, quibusdam quos recusandae rem \" + \"sit vitae. Asperiores eveniet excepturi facilis quasi suscipit?";

        ArrayList < items_class > itemsArrayList2 = new ArrayList <> ( );

        itemsArrayList2.add ( new items_class ( "1" , "black BMW 2020" , 21000f , true , desc ,
                                                "image1" , 0 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "2" ,
                                                "black BMW 2020 black BMW 2020 black BMW " +
                                                "2020 black BMW 2020 black BMW 2020" , 2500f ,
                                                false , desc , "image1" , 15 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "3" , "black BMW 2020" , 220000f , false , desc ,
                                                "image2" , 10 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "4" , "black BMW 2020" , 21000f , true , desc ,
                                                "image1" , 5 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "5" , "black BMW 2020" , 36000F , false , desc ,
                                                "image2" , 70 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "6" , "black BMW 2020" , 21000f , true , desc ,
                                                "image2" , 5 , id , "BMW" ,
                                                images[ rand.nextInt ( images.length ) ] ) );

        for ( int i = 7 ; i < 50 ; i++ ) {
            itemsArrayList2.add ( new items_class ( i + "" , "black BMW 2020" , 20000f , true ,
                                                    desc , "image1" , 5 , id , "BMW" ,
                                                    images[ rand.nextInt ( images.length ) ] ) );
            itemsArrayList2.add ( new items_class ( i + "" , "black BMW 2020" , 20000f , true ,
                                                    desc , "image2" , 5 , id , "BMW" ,
                                                    images[ rand.nextInt ( images.length ) ] ) );
        }

        //End Getting Data

        section_fragment_title.setText ( "Get The Title From The Database" );
        section_fragment_title.setText ("الإلكترونيات والأجهزة المنزلية" );


        ItemsRecyclerAdapter itemsRecyclerAdapter =
                new ItemsRecyclerAdapter ( itemsArrayList2 , R.layout.item_schema_2 ,
                                           new OnItemsRecyclerViewClickListener ( ) {
                                               @Override
                                               public void onItemClick ( String id ) {

                                               }


                                               @Override
                                               public void onItemClick ( items_class selected_item ) {
                                                   Intent intent = new Intent ( getBaseContext() , Details.class );
                                                   intent.putExtra ( "selected_item" , selected_item );
                                                   startActivity ( intent );
                                               }
                                           } );

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager ( 1 , 1 );

        rv_items.setHasFixedSize ( true );
        rv_items.setLayoutManager ( layoutManager );
        rv_items.setAdapter ( itemsRecyclerAdapter );


    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        // Inflate the menu; this adds main to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.sections_menu , menu );

        //Start Notification Count
        //        MenuItem menuItem            = menu.findItem ( R.id.action_notifications );
        //        View     view                = menuItem.getActionView ( );
        //        TextView notifications_count = view.findViewById ( R.id.notifications_count );
        //        notifications_count.setText ( "9+" );
        //End Notification Count


        return true;
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {
        // Handle action bar item_schema clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        if ( id == R.id.action_Main ) {
//            openMainFragment ( );
        }
        if ( id == R.id.action_cart ) {
//            openCartFragment ( );
        }


        return super.onOptionsItemSelected ( item );
    }
}
