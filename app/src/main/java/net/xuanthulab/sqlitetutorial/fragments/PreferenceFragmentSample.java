package net.xuanthulab.sqlitetutorial.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import net.xuanthulab.sqlitetutorial.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PreferenceFragmentSample extends PreferenceFragment {

    public PreferenceFragmentSample() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }
}