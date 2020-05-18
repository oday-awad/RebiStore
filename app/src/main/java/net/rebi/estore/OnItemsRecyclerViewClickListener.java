package net.rebi.estore;

import net.rebi.estore.classes.items_class;

public interface OnItemsRecyclerViewClickListener {
    void onItemClick ( String id );

    void onItemClick ( items_class selected_item );
}
