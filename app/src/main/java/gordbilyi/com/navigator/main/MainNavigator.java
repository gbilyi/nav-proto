package gordbilyi.com.navigator.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.Stack;

import gordbilyi.com.navigator.R;
import gordbilyi.com.navigator.settings.SettingsContract;
import gordbilyi.com.navigator.sharing.SharingContract;

/**
 * Created by gordbilyi on 15/08/17.
 */

public class MainNavigator implements MainContract.Navigator {

    private final ViewPager mViewPager;
    private final BottomNavigationView mBottomNavigationView;
    private final FragmentActivity mActivity;
    private Stack<Integer> mStack = new Stack<>();

    public MainNavigator(ViewPager mViewPager, BottomNavigationView mBottomNavigationView, FragmentActivity mActivity) {
        this.mViewPager = mViewPager;
        this.mBottomNavigationView = mBottomNavigationView;
        this.mActivity = mActivity;
    }

    @Override
    public boolean selectPreviousTab() {

        boolean checkSettings = getSettingsNavigatorProvider().getNavigator().popSubFragment();
        boolean checkSharing = getSharingNavigatorProvider().getNavigator().popSubFragment();

        if (checkSettings || checkSharing) {
            return true;
        }

        if (!mStack.isEmpty()) {
            mStack.pop();
        }

        if (mStack.isEmpty()) {
            return false;
        } else {
            showViewNumber(mStack.pop());
        }

        return true;
    }

    @Override
    public void selectSpacesTab() {
        showViewNumber(0);
    }

    @Override
    public void selectSharingTab() {
        showViewNumber(1);
    }

    @Override
    public void selectSettingsTab() {
        showViewNumber(2);
    }

    @Override
    public void selectTabByIndex(int tabIndex) {
        switch (tabIndex) {
            case 0: {
                selectSpacesTab();
                break;
            }
            case 1: {
                selectSharingTab();
                break;
            }
            case 2: {
                selectSettingsTab();
                break;
            }

        }
    }

    @Override
    public void selectTabById(int tabId) {
        switch (tabId) {
            case R.id.navigation_home: {
                selectSpacesTab();
                break;
            }
            case R.id.navigation_dashboard: {
                selectSharingTab();
                break;
            }
            case R.id.navigation_notifications: {
                selectSettingsTab();
                break;
            }
        }
    }

    private void showViewNumber(int number) {
        mBottomNavigationView.setSelectedItemId(number);
        mViewPager.setCurrentItem(number);

        // handle first element
        if (mStack.isEmpty()) {
            mStack.push(number);
            return;
        }

        // do not put same page to the stack again
        if (mStack.peek() != number) {

            // once selected Spaces, again, forget all the history
            if (number == 0) {
                mStack.removeAllElements();
            }

            mStack.push(number);
        }
    }

    private SettingsContract.NavigatorProvider getSettingsNavigatorProvider() {
        return (SettingsContract.NavigatorProvider) mActivity.getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 2 /*Settings*/));
    }

    private SharingContract.NavigatorProvider getSharingNavigatorProvider() {
        return (SharingContract.NavigatorProvider) mActivity.getSupportFragmentManager()
                .findFragmentByTag(getFragmentTag(mViewPager.getId(), 1 /*Sharing*/));
    }


    private String getFragmentTag(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }
}
