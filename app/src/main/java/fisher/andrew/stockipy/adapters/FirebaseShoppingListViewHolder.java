package fisher.andrew.stockipy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.models.Food;

/**
 * Created by andrewfisher on 12/6/16.
 */

//technically could be refractored with kitchenview holder but down the road there functionality will differ
public class FirebaseShoppingListViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseShoppingListViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindShoppingList(Food item){
        TextView shoppingListItem = (TextView) mView.findViewById(R.id.foodListItem);
        shoppingListItem.setText(item.getName());

    }
}
