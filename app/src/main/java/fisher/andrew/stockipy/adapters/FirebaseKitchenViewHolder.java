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

public class FirebaseKitchenViewHolder extends RecyclerView.ViewHolder {
    public TextView mKitchenItemTextView;
    View mView;
    Context mContext;

    public FirebaseKitchenViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindKitchen(Food item){
        mKitchenItemTextView = (TextView) mView.findViewById(R.id.foodListItem);
        mKitchenItemTextView.setText(item.getName());

    }



}
