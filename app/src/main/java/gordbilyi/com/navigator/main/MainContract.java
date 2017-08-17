package gordbilyi.com.navigator.main;


import android.support.annotation.NonNull;

/**
 * Created by gordbilyi on 15/08/17.
 */

public interface MainContract {


    interface View extends gordbilyi.com.navigator.Presenter.View {
        void start();
    }

    interface Presenter extends gordbilyi.com.navigator.Presenter<View> {

        void setNavigator(@NonNull MainContract.Navigator navigator);

        void selectSpacesTab();
        void selectSharingTab();
        void selectSettingsTab();
        boolean selectPreviousTab();
        void selectTabByIndex(int tabIndex);
        void selectTabById(int tabId);
    }

    interface Navigator {
        void selectSpacesTab();
        void selectSharingTab();
        void selectSettingsTab();
        boolean selectPreviousTab();
        void selectTabByIndex(int tabIndex);
        void selectTabById(int tabId);
    }

    interface NavigatorProvider {
        Navigator getNavigator();
    }

}
