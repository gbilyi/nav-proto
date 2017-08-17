package gordbilyi.com.navigator.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import gordbilyi.com.navigator.R;
import gordbilyi.com.navigator.settings.details.SettingsDetailsOne;


public class SettingsFragment extends PreferenceFragmentCompat
        implements SettingsContract.NavigatorProvider, SettingsContract.View,
        SettingsDetailsOne.FragmentInteractionListener {

    private SettingsContract.Presenter mPresenter;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.pref_details1, rootKey);

        mPresenter = createPresenter();

        findPreference("pref_1").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                mPresenter.showDetailsOne();
                return true;
            }
        });

    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @NonNull
    protected SettingsContract.Presenter createPresenter() {
        SettingsContract.Presenter presenter = new SettingsPresenter();
        presenter.setNavigator(getNavigator());
        return presenter;
    }

    @Override
    public SettingsContract.Navigator getNavigator() {
        return new SettingsNavigator(this);
    }


    public SettingsContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void displaySettings() {
        // unused
    }

    @Override
    public void onPreferenceSelected(String prefKey) {
        // drill down
        mPresenter.showDetailsTwo();
    }

}
