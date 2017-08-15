package gordbilyi.com.navigator.sharing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gordbilyi.com.navigator.R;


public class SharingFragment extends Fragment implements SharingContract.NavigatorProvider {

    public SharingFragment() {
        // Required empty public constructor
    }

    public static SharingFragment newInstance() {
        return new SharingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sharing, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNavigator().openDetails();
            }
        });

        return view;
    }

    @Override
    public SharingContract.Navigator getNavigator() {
        return new SharingNavigator(this);
    }
}
