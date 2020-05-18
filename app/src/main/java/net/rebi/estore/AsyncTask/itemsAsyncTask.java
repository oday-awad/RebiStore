package net.rebi.estore.AsyncTask;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.adapters.ItemsRecyclerAdapter;
import net.rebi.estore.classes.items_class;

import java.util.ArrayList;
import java.util.Random;

public class itemsAsyncTask extends AsyncTask < String, ArrayList < items_class >,
        ArrayList < items_class > > {

    private static Integer[]                        IMAGES =
            { R.drawable.car , R.drawable.shopping , R.drawable.image1 };
    private        OnItemsRecyclerViewClickListener listener;
    private        RecyclerView                     rv_items;

    public itemsAsyncTask ( RecyclerView rv_items , OnItemsRecyclerViewClickListener listener ) {
        this.listener = listener;
        this.rv_items = rv_items;
    }


    @Override
    protected ArrayList < items_class > doInBackground ( String... strings ) {
        String id = strings[ 0 ];
        return getData ( id );
    }


    @Override
    protected void onPostExecute ( final ArrayList < items_class > items_ArrayList ) {

        //Start RecyclerView And The Adapter

        ItemsRecyclerAdapter itemsRecyclerAdapter =
                new ItemsRecyclerAdapter ( items_ArrayList , R.layout.item_schema ,
                                           new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) { }

                    @Override
                    public void onItemClick ( items_class item ) {
                        listener.onItemClick ( item );
                    }
                } );

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager ( 1 , 0 );

        rv_items.setHasFixedSize ( true );
        rv_items.setLayoutManager ( layoutManager );
        rv_items.setAdapter ( itemsRecyclerAdapter );


        //End RecyclerView And The Adapter


        super.onPostExecute ( items_ArrayList );
    }

    public ArrayList < items_class > getData ( String id ) {
        String desc =
                "Lorem ipsum dolor sit amet consectetur elit. Aliquam asperiores commodi " +
                "debitis " + "dolores eum excepturi magni mollitia, quaerat, quibusdam quos" + " "
                + "recusandae rem " + "sit vitae. Asperiores eveniet excepturi facilis quasi" +
                " suscipit?Lorem ipsum dolor sit amet consectetur elit. Aliquam asperiores " +
                "commodi debitis \"\n" + "                + \"dolores eum excepturi magni " +
                "mollitia, quaerat, quibusdam quos recusandae rem \" + \"sit vitae. " +
                "Asperiores eveniet excepturi facilis quasi suscipit?";

        Random rand = new Random ( );

        ArrayList < items_class > itemsArrayList = new ArrayList <> ( );

        itemsArrayList.add ( new items_class ( "1" , "black BMW 2020" , 21000f , true , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 0 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList.add ( new items_class ( "2" , "black BMW 2020 black BMW 2020 " , 2500f ,
                                               false , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 15 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList.add ( new items_class ( "3" , "black BMW 2020" , 220000f , false , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 10 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList.add ( new items_class ( "4" , "black BMW 2020" , 21000f , true , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 5 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList.add ( new items_class ( "5" , "black BMW 2020" , 36000F , false , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 70 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList.add ( new items_class ( "6" , "black BMW 2020" , 21000f , true , desc ,
                                               IMAGES[ rand.nextInt ( IMAGES.length ) ].toString ( ) , 5 , id , "BMW" , IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );
        return itemsArrayList;
    }
}
