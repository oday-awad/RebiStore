package net.rebi.estore.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.adapters.SectionsRecyclerAdapter;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.classes.sections_class;

import java.util.ArrayList;


public class SectionsAsyncTask extends AsyncTask < String, ArrayList < sections_class >,
        ArrayList < sections_class > > {

    private OnItemsRecyclerViewClickListener listener;
    private Context                          context;
    private SectionsRecyclerAdapter          sectionsRecyclerAdapter;
    private RecyclerView                     rv_sections;
    private ProgressBar                      progressBar;

    public SectionsAsyncTask (
            Context context , SectionsRecyclerAdapter sectionsRecyclerAdapter ,
            RecyclerView rv_sections , ProgressBar progressBar ,
            OnItemsRecyclerViewClickListener listener
    ) {
        this.context = context;
        this.sectionsRecyclerAdapter = sectionsRecyclerAdapter;
        this.rv_sections = rv_sections;
        this.progressBar = progressBar;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute ( ) {
        super.onPreExecute ( );
    }

    @Override
    protected ArrayList < sections_class > doInBackground ( String... strings ) {

        try {
            Thread.sleep ( 1000 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }

        //Start Getting data
        ArrayList < sections_class > sections_arrayList = new ArrayList <> ( );
        sections_arrayList.add ( new sections_class ( "1" , "وصلنا حديثاً" ) );
        sections_arrayList.add ( new sections_class ( "2" , "عروض مميزة" ) );
        sections_arrayList.add ( new sections_class ( "3" , "التخفيضات والعروض" ) );
        sections_arrayList.add ( new sections_class ( "4" , "الأطفال و الألعاب" ) );
        sections_arrayList.add ( new sections_class ( "5" , "الإلكترونيات والأجهزة المنزلية" ) );
        sections_arrayList.add ( new sections_class ( "6" , "الصحة والجمال" ) );
        sections_arrayList.add ( new sections_class ( "7" , "المكتبة" ) );
        sections_arrayList.add ( new sections_class ( "8" , "المنزل" ) );
        sections_arrayList.add ( new sections_class ( "9" , "الهواتف والتابليت وملحقاتها" ) );
        sections_arrayList.add ( new sections_class ( "10" , "سوبر ماركت" ) );
        sections_arrayList.add ( new sections_class ( "11" , "فاشن" ) );
        sections_arrayList.add ( new sections_class ( "12" , "توصيل مجاني" ) );
        //End Getting data


        sectionsRecyclerAdapter =
                new SectionsRecyclerAdapter ( sections_arrayList , context ,
                                              new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {listener.onItemClick ( id ); }

                    @Override
                    public void onItemClick ( items_class selected_item ) {
                        listener.onItemClick ( selected_item );

                    }
                } );


        return sections_arrayList;
    }

    @Override
    protected void onPostExecute ( ArrayList < sections_class > sections_arrayList ) {

        //Start RecyclerView And The Adapter
        //            SectionsRecyclerAdapter =
        //                    new SectionsRecyclerAdapter ( sections_arrayList , getContext ( ) ,
        //                                                  new OnItemsRecyclerViewClickListener
        //                                                  ( ) {
        //                                                      @Override
        //                                                      public void onItemClick ( String
        //                                                      id ) {listener.onItemClick ( id ); }
        //
        //                                                      @Override
        //                                                      public void onItemClick (
        //                                                      items_class selected_item ) {
        //                                                          Intent intent = new Intent (
        //                                                          getContext ( ) , Details
        //                                                          .class );
        //                                                          intent.putExtra (
        //                                                          "selected_item" ,
        //                                                          selected_item );
        //                                                          startActivity ( intent );
        //                                                      }
        //                                                  } );

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager ( 1 , 1 );
        rv_sections.setHasFixedSize ( true );
        rv_sections.setLayoutManager ( layoutManager );
        rv_sections.setAdapter ( sectionsRecyclerAdapter );
        //End RecyclerView And The Adapter


        progressBar.setVisibility ( View.GONE );
        super.onPostExecute ( sections_arrayList );
    }

}
