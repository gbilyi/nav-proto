package gordbilyi.com.navigator.settings;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import gordbilyi.com.navigator.settings.details.SettingsDetailsTwo;
import gordbilyi.com.navigator.settings.details.SettingsDetailsOne;

/**
 * Created by gordbilyi on 15/08/17.
 */

public class SettingsNavigator implements SettingsContract.Navigator {

    private final FragmentManager mFragmentManager;

    public SettingsNavigator(Fragment mFragment) {
        this.mFragmentManager = mFragment.getChildFragmentManager();
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
