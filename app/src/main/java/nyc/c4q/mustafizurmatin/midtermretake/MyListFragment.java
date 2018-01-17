package nyc.c4q.mustafizurmatin.midtermretake;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {
    private View rootView;
    private TextView textView;

    public MyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        Bundle bundle = getArguments();
        String text = bundle.getString("username");
        textView = (TextView) rootView.findViewById(R.id.fragment_textview);
        textView.setText(text);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            integerArrayList.add(i);
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recyclerview);
        MyAdapter listAdapter = new MyAdapter(integerArrayList );
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listAdapter);
        return rootView;
    }



}
