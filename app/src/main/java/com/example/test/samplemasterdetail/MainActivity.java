package com.example.test.samplemasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.AboutFragment;
import com.example.test.samplemasterdetail.fragments.DetailsFragment;
import com.example.test.samplemasterdetail.fragments.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainFragment.OnToonClickCallback {
    private static final String TAG = "MainActivityTAG_";

    //Keys used in bundles while passing information through activities or Android components
    public static final String DETAILS_KEY = "BUNDLE_DETAILS_KEY";
    private static final String ABOUT_FRAGMENT_KEY = "ABOUT_FRAGMENT_KEY_BUNDLE";

    private MainFragment mMainFragment;
    private DetailsFragment mDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveFragments();
        setupToolbar();
        setTitleBar();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //Hide the toggleGrid version if we have a tablet layout
        menu.findItem(R.id.main_menu_toggle).setVisible(!isTablet());
        return super.onPrepareOptionsMenu(menu);
    }

    //Instead of going back in the stack (or its normal behavior), close
    //the DrawerLayout when the back button is pressed
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            shareApp();
        } else if (id == R.id.nav_about) {
            showAbout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void toonClicked(RelatedTopic relatedTopic) {
        if (isTablet()) {
            refreshDetailsFragment(relatedTopic);
        } else {
            launchDetailsActivity(relatedTopic);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.main_menu_toggle) {
            refreshRecyclerLayout();
        }

        return super.onOptionsItemSelected(item);
    }

    //Show about dialog with the information of the app
    private void showAbout() {
        AboutFragment aboutFragment = new AboutFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        aboutFragment.show(fragmentManager, ABOUT_FRAGMENT_KEY);
    }

    //Start an Intent to share the application with an implicit-intent
    private void shareApp() {
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Check this cool app!");
        intent.setType("text/plain");

        startActivity(intent);
    }

    //Retrieve the fragments references
    private void retrieveFragments() {
        mMainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_fragment);
        mDetailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.details_fragment);

        if (mMainFragment != null && isTablet()) {
            //Fallback to normal view (no grid) in MainFragment if is tablet
            mMainFragment.setFalseGrid();
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void refreshRecyclerLayout() {
        if (mMainFragment != null) {
            //Toggle the RecyclerView layout
            mMainFragment.toggleGrid();
        }
    }

    private void setTitleBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.app_name);
            actionBar.setSubtitle(getString(R.string.activity_main_name));
        }
    }

    //Check if it is a tablet size, we can know that if we have a non-null reference of the
    //DetailsFragment AND check if it's added in the layout.
    private boolean isTablet() {
        return mDetailsFragment != null && mDetailsFragment.isAdded();
    }

    //Create an Intent to launch the DetailsActivity with a reference of the current Character
    private void launchDetailsActivity(RelatedTopic relatedTopic) {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra(DETAILS_KEY, relatedTopic);
        startActivity(intent);
    }

    //Refresh the DetailsFragment view, usually after the Retrofit instance has finished its
    //data transfer
    private void refreshDetailsFragment(RelatedTopic relatedTopic) {
        if (mDetailsFragment != null) {
            mDetailsFragment.refreshDetails(relatedTopic);
        }
    }
}
