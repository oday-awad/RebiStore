package net.rebi.estore.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.activities.Details;
import net.rebi.estore.adapters.SectionsRecyclerAdapter;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.classes.sections_class;

import java.util.ArrayList;

public class DetailsFragment extends Fragment {

    private TextView                details_item_title;
    private RecyclerView            rv_sections;
    private SectionsRecyclerAdapter sectionsRecyclerAdapter;
    private TextView                details_item_market;


    private OnItemsRecyclerViewClickListener listener;


    public DetailsFragment ( ) {
        // Required empty public constructor
    }

    public DetailsFragment ( OnItemsRecyclerViewClickListener listener ) {
        this.listener = listener;
    }


    @Override
    public View onCreateView (
            LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate ( R.layout.details_fragment , container , false );

        rv_sections = root.findViewById ( R.id.rv_sections );
        details_item_title = root.findViewById ( R.id.details_item_title );
        details_item_market = root.findViewById ( R.id.details_item_market );
        TextView  details_item_price       = root.findViewById ( R.id.details_item_price );
        TextView  details_item_finalPrice  = root.findViewById ( R.id.details_item_finalPrice );
        TextView  details_item_delivery    = root.findViewById ( R.id.details_item_delivery );
        TextView  details_item_colors      = root.findViewById ( R.id.details_item_colors );
        TextView  details_item_sizes       = root.findViewById ( R.id.details_item_sizes );
        TextView  details_item_brand       = root.findViewById ( R.id.details_item_brand );
        ImageView details_item_brand_logo  = root.findViewById ( R.id.details_item_brand_logo );
        TextView  details_item_model       = root.findViewById ( R.id.details_item_model );
        TextView  details_item_description = root.findViewById ( R.id.details_item_description );
        ImageView details_item_image       = root.findViewById ( R.id.details_item_image );


        Bundle      bundle = getArguments ( );
        items_class item   = ( items_class ) bundle.getSerializable ( "selected_item" );


        details_item_title.setText ( item.getTitle ( ) );
        details_item_market.setText ( "market name" );
        details_item_price.setText ( item.getPrice ( ) + "" );
        details_item_finalPrice.setText ( "final price" );
        details_item_brand.setText ( item.getCompany_name ( ) );
        details_item_description.setText ( item.getDescription ( ) );

        if ( item.isDelivery ( ) ) {
            details_item_delivery.setVisibility ( View.VISIBLE );
        }
        else {
            details_item_delivery.setVisibility ( View.INVISIBLE );
        }

        //        if(item.getImage ().equals ( "image1" )){
        details_item_image.setImageResource ( item.getImage2 ( ) );
        //        }else{
        //            details_item_image.setImageResource ( R.drawable.shopping );
        //
        //        }


        //Start Getting data
        ArrayList < sections_class > arrayList2 = new ArrayList <> ( );
        arrayList2.add ( new sections_class ( item.getSection_id ( ) , "منتجات من نفس القسم" ) );
        arrayList2.add ( new sections_class ( "2" , "منتجات من نفس الماركة" ) );
        //End Getting data


        //Start RecyclerView And The Adapter
        sectionsRecyclerAdapter =
                new SectionsRecyclerAdapter ( arrayList2 , getContext ( ) ,
                                              new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {
                        listener.onItemClick ( id );
                    }


                    @Override
                    public void onItemClick ( items_class selected_item ) {
                        Intent intent = new Intent ( getActivity () , Details.class );
                        intent.putExtra ( "selected_item" , selected_item );
                        startActivity ( intent );
                    }
                } );
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager ( 1 , 1 );
        rv_sections.setHasFixedSize ( true );
        rv_sections.setLayoutManager ( layoutManager );
        rv_sections.setAdapter ( sectionsRecyclerAdapter );
        //End RecyclerView And The Adapter

        return root;
    }


}
