package gordbilyi.com.navigator.settings;

import android.support.annotation.NonNull;

/**
 * Created by gordbilyi on 16/08/17.
 */

public class SettingsPresenter implements SettingsContract.Presenter {

    private SettingsContract.View mView;
    private SettingsContract.Navigator mNavigator;


    @Override
    public void onAttachView(SettingsContract.View view) {
        mView = view;

        // start whatever on creation
    }

    public void setNavigator(@NonNull final SettingsContract.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showDetailsOne() {
        mNavigator.openDetailsOne();
    }

    @Override
    public void showDetailsTwo() {
        mNavigator.openDetailsTwo();
    }


    @Override
    public void onDetachView() {
        mView = null;
        mNavigator = null;
    }
}
