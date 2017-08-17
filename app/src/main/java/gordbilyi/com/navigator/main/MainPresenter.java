package gordbilyi.com.navigator.main;

import android.support.annotation.NonNull;

/**
 * Created by gordbilyi on 17/08/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Navigator mNavigator;

    @Override
    public void onAttachView(MainContract.View view) {
        mView = view;
        // do init here
        mView.start();
    }

    @Override
    public void onDetachView() {
        mView = null;
        mNavigator = null;
    }

    @Override
    public void setNavigator(@NonNull MainContract.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void selectSpacesTab() {
        mNavigator.selectSpacesTab();
    }

    @Override
    public void selectSharingTab() {
        mNavigator.selectSharingTab();
    }

    @Override
    public void selectSettingsTab() {
        mNavigator.selectSettingsTab();
    }

    @Override
    public boolean selectPreviousTab() {
        return mNavigator.selectPreviousTab();
    }

    @Override
    public void selectTabByIndex(int tabIndex) {
        mNavigator.selectTabByIndex(tabIndex);
    }

    @Override
    public void selectTabById(int tabId) {
        mNavigator.selectTabById(tabId);
    }
}
