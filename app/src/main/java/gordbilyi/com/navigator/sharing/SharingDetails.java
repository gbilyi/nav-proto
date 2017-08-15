package gordbilyi.com.navigator.sharing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gordbilyi.com.navigator.R;

public class SharingDetails extends Fragment {

    public SharingDetails() {
        // Required empty public constructor
    }

    public static SharingDetails newInstance() {
        return new SharingDetails();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkBackgroundTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        return localInflater.inflate(R.layout.fragment_sharing_details_1, container, false);
    }

}
