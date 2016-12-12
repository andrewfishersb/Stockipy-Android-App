package fisher.andrew.stockipy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fisher.andrew.stockipy.R;

/**
 * Created by andrewfisher on 12/6/16.
 */


//will need for when i try out swiping and clicking, so this might be pointless for now, we shall see
public class FirebaseKitchenViewHolder extends RecyclerView.ViewHolder {
    View mView;
    Context mContext;

    public FirebaseKitchenViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindKitchen(String item){
        TextView kitchenItem = (TextView) mView.findViewById(R.id.listHeaderTextView);
        kitchenItem.setText(item);

    }

    //usually have the onClick here but this is a string literal


}
