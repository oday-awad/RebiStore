package net.rebi.estore.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.classes.items_class;

import java.util.ArrayList;
import java.util.Random;

//TODO Make Adapter For Cart Only
public class ItemsRecyclerAdapter extends RecyclerView.Adapter < ItemsRecyclerAdapter.ViewHolder > {

    Integer[] images =
            { R.drawable.car , R.drawable.shopping , R.drawable.image1 };
    private int                              Layout;
    private OnItemsRecyclerViewClickListener listener;
    private ArrayList < items_class >        items_arrayList;

    //constructor
    public ItemsRecyclerAdapter (
            ArrayList < items_class > items_arrayList , int Layout ,
            OnItemsRecyclerViewClickListener listener
    ) {
        this.items_arrayList = items_arrayList;
        this.Layout = Layout;
        this.listener = listener;
    }

    //Start OnCreate
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {

        //        LayoutInflater mInflater = getLayoutInflater ( );
        View myView =
                LayoutInflater.from ( parent.getContext ( ) ).inflate ( Layout , null , false );

        return new ViewHolder ( myView );
    }//End OnCreate

    //Start OnBind
    @Override
    public void onBindViewHolder ( @NonNull ViewHolder holder , final int position ) {




        Float price       = items_arrayList.get ( position ).getPrice ( );
        int   sales       = items_arrayList.get ( position ).getSales ( );
        Float final_price = price - ( price * sales / 100 );

        holder.item_company.setText ( items_arrayList.get ( position ).getCompany_name ( ) );
        holder.item_title.setText ( items_arrayList.get ( position ).getTitle ( ) );
        holder.item_price.setText ( String.format ( "%s $" , price ) );
        holder.item_sale.setText ( String.format ( "%d%%" , sales ) );
        holder.item_finalPrice.setText ( String.format ( "%s $" , final_price ) );
        if ( sales == 0 ) {
            holder.item_sales_layout.setVisibility ( View.INVISIBLE );
        }
        else {
            holder.item_sales_layout.setVisibility ( View.VISIBLE );

        }

        if ( items_arrayList.get ( position ).isDelivery ( ) ) {
            holder.item_delivery.setVisibility ( View.VISIBLE );
            holder.item_delivery.setText ( "التوصيل مجاني" );
            //            holder.item_delivery.setCompoundDrawables (  );
        }
        else {
            holder.item_delivery.setVisibility ( View.INVISIBLE );
        }


//        if ( items_arrayList.get ( position ).getImage ( ).equals ( "image1" ) ) {
//            holder.item_imageView.setImageResource ( R.drawable.car );
//        }
//        else
//            if ( items_arrayList.get ( position ).getImage ( ).equals ( "image2" ) ) {
//                holder.item_imageView.setImageResource ( R.drawable.shopping );
//            }

        holder.item_imageView.setImageResource ( items_arrayList.get ( position ).getImage2 ());


        //Start On Click
        holder.myView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                listener.onItemClick ( items_arrayList.get ( position ) );
            }
        } );
        //End On Click

    }//End OnBind


    //Start GetItemCount
    @Override
    public int getItemCount ( ) {
        return items_arrayList.size ( );
    }//End GetItemCount


    //Start View Holder
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView     item_company;
        TextView     item_title;
        TextView     item_price;
        TextView     item_sale;
        TextView     item_finalPrice;
        TextView     item_delivery;
        LinearLayout item_sales_layout;
        View         myView;
        ImageView    item_imageView;
        //        TextView  textView;
        //        Button    button;

        ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            myView = itemView;
            item_imageView = itemView.findViewById ( R.id.item_imageView );
            item_company = itemView.findViewById ( R.id.item_company );
            item_title = itemView.findViewById ( R.id.item_title );
            item_price = itemView.findViewById ( R.id.item_price );
            item_sale = itemView.findViewById ( R.id.item_sale );
            item_finalPrice = itemView.findViewById ( R.id.item_finalPrice );
            item_delivery = itemView.findViewById ( R.id.item_delivery );
            item_sales_layout = itemView.findViewById ( R.id.item_sales_layout );


        }

    }//End View Holder

}
