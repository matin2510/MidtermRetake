package nyc.c4q.mustafizurmatin.midtermretake;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 1/16/18.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    public ItemViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.itemview_textview);
    }

    public void onBind(final Integer integer) {
        textView.setText(Integer.toString(integer));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment myNumberFragment = new FirstFragment();
                FragmentManager fragmentManager = ((ListActivity) itemView.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("integer", Integer.toString(integer));
                myNumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, myNumberFragment);
                fragmentTransaction.addToBackStack("number");
                fragmentTransaction.commit();
            }
        });
    }
}
