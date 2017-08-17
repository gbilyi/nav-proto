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
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainContract.NavigatorProvider, MainContract.View {

    private BottomNavigationView mNavigation;
    private ViewPager mViewPager;
    private MainContract.Navigator mNavigator;
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timber.plant(new Timber.DebugTree());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initNavigation();

        mPresenter = new MainPresenter();
        mNavigator = new MainNavigator(mViewPager, mNavigation, this);
    }

    @Override
    public MainContract.Navigator getNavigator() {
        // maybe redundant
        return mNavigator;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.setNavigator(mNavigator);
        mPresenter.onAttachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onDetachView();
    }


    @Override
    public void onBackPressed() {
        if (!mPresenter.selectPreviousTab()) {
            super.onBackPressed();
        }
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
                mPresenter.selectTabByIndex(position);
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

    private void initNavigation() {
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mPresenter.selectTabById(item.getItemId());
                return true;
            }

        });
    }

    public void onClick(View view) {
        mPresenter.selectSettingsTab();
    }


    @Override
    public void start() {
        mPresenter.selectSpacesTab();
    }
}
