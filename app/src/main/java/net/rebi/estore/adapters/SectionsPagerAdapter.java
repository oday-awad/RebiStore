package net.rebi.estore.adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.fragments.CommentsFragment;
import net.rebi.estore.fragments.DetailsFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[]       TAB_TITLES =
            new int[] { R.string.tab_text_1 , R.string.tab_text_2  };
    private final        Context     mContext;
    private              items_class item ;
    private OnItemsRecyclerViewClickListener listener;


    public SectionsPagerAdapter ( Context context , FragmentManager fm , items_class item ,     OnItemsRecyclerViewClickListener listener
    ) {
        super ( fm );
        mContext = context;
        this.item = item;
        this.listener=listener;
    }

    @Override
    public Fragment getItem ( int position ) {
        Bundle bundle = new Bundle();
        switch ( position ) {
            case 0:
                bundle.putSerializable ("selected_item" , item  );
                DetailsFragment detailsFragment = new DetailsFragment ( new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {
                        listener.onItemClick ( id );
                    }

                    @Override
                    public void onItemClick ( items_class selected_item ) {

                    }
                } );
                detailsFragment.setArguments ( bundle );
                return detailsFragment;
            case 1:

                bundle.putSerializable ("selected_item" , item  );
                CommentsFragment commentsFragment =
                        new CommentsFragment ( new OnItemsRecyclerViewClickListener ( ) {
                @Override
                public void onItemClick ( String id ) {
                    listener.onItemClick ( id );
                }

                @Override
                public void onItemClick ( items_class selected_item ) {

                }
            } );
                commentsFragment.setArguments ( bundle );
                return commentsFragment;


            default:

                bundle.putSerializable ("selected_item" , item  );
                DetailsFragment detailsFragment2 = new DetailsFragment ( new OnItemsRecyclerViewClickListener ( ) {
                    @Override
                    public void onItemClick ( String id ) {
                        listener.onItemClick ( id );
                    }

                    @Override
                    public void onItemClick ( items_class selected_item ) {

                    }
                } );
                detailsFragment2.setArguments ( bundle );
                return detailsFragment2;


        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle ( int position ) {
        return mContext.getResources ( ).getString ( TAB_TITLES[ position ] );
    }

    @Override
    public int getCount ( ) {
        return TAB_TITLES.length;
    }
}