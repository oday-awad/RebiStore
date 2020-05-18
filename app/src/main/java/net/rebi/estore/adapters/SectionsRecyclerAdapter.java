package net.rebi.estore.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.classes.sections_class;
import net.rebi.estore.AsyncTask.itemsAsyncTask;

import java.util.ArrayList;

public class SectionsRecyclerAdapter extends RecyclerView.Adapter < SectionsRecyclerAdapter.ViewHolder > {

    private static Integer[]                        IMAGES =
            { R.drawable.car , R.drawable.shopping , R.drawable.image1 };
    private        OnItemsRecyclerViewClickListener listener;
    private        ArrayList < sections_class >     sectionsArrayList;


    //constructor
    public SectionsRecyclerAdapter (
            ArrayList < sections_class > arrayList , Context context ,
            OnItemsRecyclerViewClickListener listener
    ) {
        this.sectionsArrayList = arrayList;
        this.listener = listener;
    }


    //Start OnCreate
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
        View myView =
                LayoutInflater.from ( parent.getContext ( ) ).inflate ( R.layout.section_schema ,
                                                                        null , false );
        return new ViewHolder ( myView );
    }//End OnCreate

    //Start OnBind
    @SuppressLint ( "SetTextI18n" )
    @Override
    public void onBindViewHolder ( @NonNull ViewHolder holder , final int position ) {
        holder.section_schema_title.setText ( sectionsArrayList.get ( position ).getId ( ) + " - "
                                              + sectionsArrayList.get ( position ).getTitle ( ) );

        holder.section_schema_button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                listener.onItemClick ( sectionsArrayList.get ( position ).getId ( ) );
            }
        } );

        try {
            Thread.sleep ( 500 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }

        new itemsAsyncTask ( holder.rv_items , new OnItemsRecyclerViewClickListener ( ) {
            @Override
            public void onItemClick ( String id ) { }

            @Override
            public void onItemClick ( items_class selected_item ) {
                listener.onItemClick ( selected_item );
            }
        } ).execute ( sectionsArrayList.get ( position ).getId ( ) , String.valueOf ( position ) );
    }//End OnBind

    //Start GetItemCount
    @Override
    public int getItemCount ( ) {
        return sectionsArrayList.size ( );
    }//End GetItemCount

    //Start View Holder
     class ViewHolder extends RecyclerView.ViewHolder {
        View     myView;
        TextView section_schema_title;
        Button   section_schema_button;
        private RecyclerView rv_items;

        ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            myView = itemView;

            rv_items = itemView.findViewById ( R.id.rv_items );
            section_schema_title = itemView.findViewById ( R.id.section_schema_title );
            section_schema_button = itemView.findViewById ( R.id.section_schema_button );

        }

    }//End View Holder
}
