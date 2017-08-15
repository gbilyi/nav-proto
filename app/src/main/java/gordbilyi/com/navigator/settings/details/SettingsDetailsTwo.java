package gordbilyi.com.navigator.settings.details;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gordbilyi.com.navigator.R;

public class SettingsDetailsTwo extends Fragment {

    public SettingsDetailsTwo() {
        // Required empty public constructor
    }

    public static SettingsDetailsTwo newInstance(String param1, String param2) {
        return new SettingsDetailsTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkBackgroundTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        return localInflater.inflate(R.layout.fragment_details_fragment2, container, false);
    }

}
