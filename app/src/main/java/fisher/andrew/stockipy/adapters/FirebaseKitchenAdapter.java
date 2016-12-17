package fisher.andrew.stockipy.adapters;


import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import fisher.andrew.stockipy.models.Food;
import fisher.andrew.stockipy.util.ItemTouchHelperAdapter;
import fisher.andrew.stockipy.util.OnStartDragListener;

public class FirebaseKitchenAdapter extends FirebaseRecyclerAdapter<Food, FirebaseKitchenViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseKitchenAdapter(Class<Food> modelClass, int modelLayout,
                                         Class<FirebaseKitchenViewHolder> viewHolderClass,
                                         Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(final FirebaseKitchenViewHolder viewHolder, Food model, int position) {
        viewHolder.bindKitchen(model);
        viewHolder.mKitchenItemTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(MotionEventCompat.getActionMasked(event)==MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(viewHolder);
                    Toast.makeText(mContext, "Does this work", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        //delete swiped item
    }
}
