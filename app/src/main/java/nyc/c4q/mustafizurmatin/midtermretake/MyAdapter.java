package nyc.c4q.mustafizurmatin.midtermretake;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by c4q on 1/16/18.
 */

public class MyAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    ArrayList<Integer> integerArrayList;
    Context context;

    public MyAdapter(ArrayList<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ItemViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Integer integer = integerArrayList.get(position);
        holder.onBind(integer);
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }
}
