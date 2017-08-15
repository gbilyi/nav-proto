package gordbilyi.com.navigator.settings;

/**
 * Created by gordbilyi on 15/08/17.
 */

public interface SettingsContract {

    interface Navigator {
        void openDetailsOne();
        void openDetailsTwo(); // drill down
        boolean popSubFragment();
    }

    interface NavigatorProvider {
        Navigator getNavigator();
    }

}
