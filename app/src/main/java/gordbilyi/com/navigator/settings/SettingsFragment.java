package gordbilyi.com.navigator.settings;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import gordbilyi.com.navigator.R;


public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.NavigatorProvider {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.pref_details1, rootKey);

        findPreference("pref_1").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                getNavigator().openDetailsOne();
                return true;
            }
        });

    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public SettingsContract.Navigator getNavigator() {
        return new SettingsNavigator(this);
    }
}
