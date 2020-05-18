package net.rebi.estore.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;


public class CommentsFragment extends Fragment {

    private OnItemsRecyclerViewClickListener listener;

    public CommentsFragment ( ) {
        // Required empty public constructor
    }

    public CommentsFragment ( OnItemsRecyclerViewClickListener listener ) {
        this.listener = listener;
    }

    @Override
    public View onCreateView (
            LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate ( R.layout.comments_fragment , container , false );


        return root;
    }

}
