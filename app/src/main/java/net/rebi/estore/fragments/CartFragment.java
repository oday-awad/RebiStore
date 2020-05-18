package net.rebi.estore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.adapters.ItemsRecyclerAdapter;
import net.rebi.estore.adapters.SectionsRecyclerAdapter;
import net.rebi.estore.classes.items_class;

import java.util.ArrayList;
import java.util.Random;


public class CartFragment extends Fragment {

    private RecyclerView            rv_items;
    private SectionsRecyclerAdapter recyclerAdapter;
    private Integer[]               IMAGES =
            { R.drawable.car , R.drawable.shopping , R.drawable.image1 };


    @Override
    public View onCreateView (
            LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate ( R.layout.cart_fragment , container , false );


        rv_items = root.findViewById ( R.id.rv_sections );
        Random rand = new Random ( );

        String desc =
                "Lorem ipsum dolor sit amet consectetur elit. Aliquam asperiores commodi debitis "
                + "dolores eum excepturi magni mollitia, quaerat, quibusdam quos recusandae rem " + "sit vitae. Asperiores eveniet excepturi facilis quasi suscipit?";

        ArrayList < items_class > itemsArrayList2 = new ArrayList <> ( );

        itemsArrayList2.add ( new items_class ( "1" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 5 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "2" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 5 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "3" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 5 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "4" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 0 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "5" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 5 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );

        itemsArrayList2.add ( new items_class ( "6" , "black BMW 2020" , 20000f , true , desc ,
                                                "image" , 5 , "from database" , "BMW" ,
                                                IMAGES[ rand.nextInt ( IMAGES.length ) ] ) );


        ItemsRecyclerAdapter itemsRecyclerAdapter =
                new ItemsRecyclerAdapter ( itemsArrayList2 , R.layout.item_schema_2 ,
                                           new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {
                        Toast.makeText ( getContext ( ) , id , Toast.LENGTH_SHORT ).show ( );
                    }


                    @Override
                    public void onItemClick ( items_class selected_item ) {

                    }
                } );

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager ( 1 , 1 );

        rv_items.setHasFixedSize ( true );
        rv_items.setLayoutManager ( layoutManager );
        rv_items.setAdapter ( itemsRecyclerAdapter );


        return root;
    }
}
