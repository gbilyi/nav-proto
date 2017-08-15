package gordbilyi.com.navigator.main;


/**
 * Created by gordbilyi on 15/08/17.
 */

public interface MainContract {

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
