package gordbilyi.com.navigator.sharing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import gordbilyi.com.navigator.R;


/**
 * Created by gordbilyi on 15/08/17.
 */

public class SharingNavigator implements SharingContract.Navigator {

    private final FragmentManager mFragmentManager;

    public SharingNavigator(Fragment mFragment) {
        this.mFragmentManager = mFragment.getChildFragmentManager();
    }

    @Override
    public void openDetails() {
        Fragment fragment = SharingDetails.newInstance();

        // Use child manager here to have independent navigation for sub-fragments of Settings
        mFragmentManager.beginTransaction()
                .add(R.id.content, fragment, fragment.getClass().getName())
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

}
