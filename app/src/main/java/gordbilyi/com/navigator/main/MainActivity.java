package gordbilyi.com.navigator.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import gordbilyi.com.navigator.R;
import gordbilyi.com.navigator.settings.SettingsFragment;
import gordbilyi.com.navigator.sharing.SharingFragment;
import gordbilyi.com.navigator.spaces.SpacesFragment;

public class MainActivity extends AppCompatActivity implements MainContract.NavigatorProvider {

    private BottomNavigationView mNavigation;
    private ViewPager mViewPager;
    private MainContract.Navigator mNavigator;

    @Override
    public MainContract.Navigator getNavigator() {
        if (mNavigator == null) {
            mNavigator = new MainNavigator(mViewPager, mNavigation, this);
        }
        return mNavigator;
    }

    @Override
    public void onBackPressed() {
        if (!getNavigator().selectPreviousTab()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();

        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getNavigator().selectTabById(item.getItemId());
                return true;
            }

        });

        getNavigator().selectSpacesTab();
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getNavigator().selectTabByIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        return SpacesFragment.newInstance();
                    case 1:
                        return SharingFragment.newInstance();
                    case 2:
                        return SettingsFragment.newInstance();
                }

                return new SpacesFragment(); // default
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    public void onClick(View view) {
        getNavigator().selectSettingsTab();
    }

}
