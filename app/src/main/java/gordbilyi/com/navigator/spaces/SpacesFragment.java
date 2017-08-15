package gordbilyi.com.navigator.spaces;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gordbilyi.com.navigator.R;


public class SpacesFragment extends Fragment {
    public SpacesFragment() {
        // Required empty public constructor
    }

    public static SpacesFragment newInstance() {
        return new SpacesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spaces, container, false);
    }

}
