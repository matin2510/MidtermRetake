package nyc.c4q.mustafizurmatin.midtermretake;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyNumberFragment extends Fragment {


    public View rootView;

    public MyNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.numbers_textview);
        Bundle bundle = getArguments();
        Integer number = Integer.parseInt(bundle.getString("integer")) * 10;
        textView.setText(Integer.toString(number));
        return rootView;
    }



}
