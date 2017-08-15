package gordbilyi.com.navigator.settings.details;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import gordbilyi.com.navigator.R;
import gordbilyi.com.navigator.settings.SettingsContract;


public class SettingsDetailsOne extends PreferenceFragmentCompat {


    public SettingsDetailsOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.pref_details2, rootKey);
        findPreference("pref_0").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                getNavigator().openDetailsTwo();
                return true;
            }
        });

    }

    public static SettingsDetailsOne newInstance() {
        return new SettingsDetailsOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkBackgroundTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        LinearLayout view = (LinearLayout) super.onCreateView(localInflater, container, savedInstanceState);
        return view;
    }


    SettingsContract.Navigator getNavigator() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof SettingsContract.NavigatorProvider) {
            return ((SettingsContract.NavigatorProvider) parentFragment).getNavigator();
        }
        throw new IllegalStateException("Must implement SettingsContract.NavigatorProvider");
    }

}
