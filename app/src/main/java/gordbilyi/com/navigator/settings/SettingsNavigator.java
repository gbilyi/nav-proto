package gordbilyi.com.navigator.settings;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import gordbilyi.com.navigator.settings.details.SettingsDetailsOne;
import gordbilyi.com.navigator.settings.details.SettingsDetailsTwo;

/**
 * Created by gordbilyi on 15/08/17.
 */

public class SettingsNavigator implements SettingsContract.Navigator {

    private Fragment mFragment;
    private final FragmentManager mFragmentManager;

    public SettingsNavigator(Fragment fragment) {
        mFragment = fragment;
        mFragmentManager = fragment.getChildFragmentManager();
    }

    public void openDetailsOne() {
        Fragment fragment = SettingsDetailsOne.newInstance();

        // Use child manager here to have independent navigation for sub-fragments of Settings
        mFragmentManager.beginTransaction()
                .add(android.R.id.list_container, fragment, fragment.getClass().getName())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean popSubFragment() {

        // allow upper navigation but do not pop the fragment if it's invisible
        if (!mFragment.getUserVisibleHint()) {
            return false;
        }

        if (mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void openDetailsTwo() {
        Fragment fragment = SettingsDetailsTwo.newInstance("", "");
        // use fragment manager (not child fragmentmanager) as it's part of SettingsFragment navigation
        mFragmentManager.beginTransaction()
                .add(android.R.id.list_container, fragment, fragment.getClass().getName())
                .addToBackStack(null)
                .commit();
    }
}
