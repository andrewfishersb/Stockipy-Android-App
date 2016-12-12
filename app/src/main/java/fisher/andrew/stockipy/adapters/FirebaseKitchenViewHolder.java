package fisher.andrew.stockipy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.models.Food;
import fisher.andrew.stockipy.ui.kitchen.KitchenActivity;

/**
 * Created by andrewfisher on 12/6/16.
 */

public class FirebaseKitchenViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public FirebaseKitchenViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);// this isnt need right?
    }

    public void bindKitchen(Food item){
        TextView kitchenItem = (TextView) mView.findViewById(R.id.foodListItem);
        kitchenItem.setText(item.getName());

    }

    @Override
    public void onClick(View v){
        final ArrayList<Food> items = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_KITCHEN);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    items.add(snapshot.getValue(Food.class));
                }
//dont need below?
                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, KitchenActivity.class);
                intent.putExtra("position",itemPosition+"");
                intent.putExtra("items", Parcels.wrap(items));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
