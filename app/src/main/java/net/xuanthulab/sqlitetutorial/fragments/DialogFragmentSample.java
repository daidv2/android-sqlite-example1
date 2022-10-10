package net.xuanthulab.sqlitetutorial.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.xuanthulab.sqlitetutorial.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DialogFragmentSample extends DialogFragment {

    public DialogFragmentSample() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_fragment_sample, container, false);
        getDialog().setTitle("This is title");
        return view;
    }
}