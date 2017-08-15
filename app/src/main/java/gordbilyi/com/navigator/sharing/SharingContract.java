package gordbilyi.com.navigator.sharing;

/**
 * Created by gordbilyi on 15/08/17.
 */

public interface SharingContract {

    interface Navigator {
        void openDetails();
        boolean popSubFragment();
    }

    interface NavigatorProvider {
        Navigator getNavigator();
    }

}
