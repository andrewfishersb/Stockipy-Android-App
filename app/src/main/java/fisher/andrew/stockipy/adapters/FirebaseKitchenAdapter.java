package fisher.andrew.stockipy.adapters;


import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Collections;

import fisher.andrew.stockipy.models.Food;
import fisher.andrew.stockipy.util.ItemTouchHelperAdapter;
import fisher.andrew.stockipy.util.OnStartDragListener;

public class FirebaseKitchenAdapter extends FirebaseRecyclerAdapter<Food, FirebaseKitchenViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Food> mKitchenFood = new ArrayList<>();

    public FirebaseKitchenAdapter(Class<Food> modelClass, int modelLayout,
                                         Class<FirebaseKitchenViewHolder> viewHolderClass,
                                         Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mKitchenFood.add(dataSnapshot.getValue(Food.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void populateViewHolder(final FirebaseKitchenViewHolder viewHolder, Food model, int position) {
        viewHolder.bindKitchen(model);
        viewHolder.mKitchenItemTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(MotionEventCompat.getActionMasked(event)==MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mKitchenFood, fromPosition, toPosition);
        notifyItemChanged(fromPosition,toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        //delete swiped item
        getRef(position).removeValue();
    }

    //will resign index property of each item
    private void setIndexInFirebase(){
        for(Food item : mKitchenFood){
            int index = mKitchenFood.indexOf(item);
            DatabaseReference ref = getRef(index);
            item.setIndex(Integer.toString(index));
            ref.setValue(item);
        }
    }

    @Override
    public void cleanup(){
        super.cleanup();
        setIndexInFirebase();
        mRef.removeEventListener(mChildEventListener);
    }
}
