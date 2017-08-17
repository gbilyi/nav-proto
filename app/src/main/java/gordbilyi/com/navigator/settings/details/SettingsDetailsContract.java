package gordbilyi.com.navigator.settings.details;

import gordbilyi.com.navigator.settings.SettingsContract;

/**
 * Created by gordbilyi on 16/08/17.
 */

public class SettingsDetailsContract {

    interface View extends gordbilyi.com.navigator.Presenter.View {
        void displaySettings();
    }

    interface Presenter extends gordbilyi.com.navigator.Presenter<View> {

        void showDetailsOne();

        void showDetailsTwo();

        void setNavigator(SettingsContract.Navigator navigator);
    }
}
