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


public class SettingsDetailsOne extends PreferenceFragmentCompat {

    public static final String PREF_KEY_DETAILS = "pref_0";
    FragmentInteractionListener mCallback;

    // Container Activity must implement this interface
    public interface FragmentInteractionListener {
        void onPreferenceSelected(String prefKey);
    }


    public SettingsDetailsOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.pref_details2, rootKey);
        findPreference(PREF_KEY_DETAILS).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                mCallback.onPreferenceSelected(PREF_KEY_DETAILS);
                return true;
            }
        });

        // This makes sure that the container context has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (FragmentInteractionListener) getParentFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(getParentFragment().toString()
                    + " must implement FragmentInteractionListener");
        }

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


}
