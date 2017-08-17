package gordbilyi.com.navigator.settings;

import android.support.annotation.NonNull;

/**
 * Created by gordbilyi on 15/08/17.
 */

public interface SettingsContract {

    interface View extends gordbilyi.com.navigator.Presenter.View {
        void displaySettings();
    }

    interface Presenter extends gordbilyi.com.navigator.Presenter<View> {

        void setNavigator(@NonNull Navigator navigator);

        void showDetailsOne();

        void showDetailsTwo();
    }

    interface Navigator {
        void openDetailsOne();

        void openDetailsTwo(); // drill down

        boolean popSubFragment();
    }

    interface NavigatorProvider {
        Navigator getNavigator();
    }

}
