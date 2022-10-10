package net.xuanthulab.sqlitetutorial.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import net.xuanthulab.sqlitetutorial.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 * Create by: Include interface callbacks?
 */
public class FirstFragment extends Fragment {

    private OnFirstFragmentListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btnItem1 = (Button) view.findViewById(R.id.btnItem1);
        Button btnItem2 = (Button) view.findViewById(R.id.btnItem2);

        btnItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    //Toast.makeText(getActivity(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
                    mListener.onItemPressed("This is a content when Button 1 click");
                }
            }
        });
        btnItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    //Toast.makeText(getActivity(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
                    mListener.onItemPressed("Hey, this is a Button 2 content");
                }
            }
        });

        return view;
    }

    // Fragment được gắn vào Activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentListener) {
            mListener = (OnFirstFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    // Fragment này bị gỡ khỏi Activity
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // MainActivity sẽ implement listener này và phương thức này
    // sẽ lấy String được truyền vào này để gởi qua SecondFragment.
    public interface OnFirstFragmentListener {
        void onItemPressed(String content);
    }
}