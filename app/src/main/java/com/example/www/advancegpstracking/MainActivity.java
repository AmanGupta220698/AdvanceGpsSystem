package com.example.www.advancegpstracking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.www.advancegpstracking.ui.AlarmModule.locationalarm.LocationAlarmActivity;
import com.example.www.advancegpstracking.ui.DistanceTrackerModule.DistanceTrackerActivity;
import com.example.www.advancegpstracking.ui.HomeModule.HomeFragment;
import com.example.www.advancegpstracking.ui.NearbyModule.NearByActivity;
import com.example.www.advancegpstracking.ui.NotificationModule.NotificationFragment;
import com.example.www.advancegpstracking.ui.TrackingModule.TrackingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            defaultfragementselect(item.getItemId());


            return true;
        }

    };
    private void defaultfragementselect(int itemId) {

        //Fragment fragement=null;
        android.support.v4.app.Fragment fragement = null;
        switch (itemId) {

            case R.id.navigation_home:
                fragement = new HomeFragment();
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_notifications:
                fragement = new NotificationFragment();
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_tracking:
                fragement = new TrackingFragment();
                Toast.makeText(this, "navigation", Toast.LENGTH_SHORT).show();
                break;



        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragement).commit();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null) {
            defaultfragementselect(R.id.navigation_home);
        }
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_exit) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

            alertDialog.setMessage("Are You Sure To Close The Application");
            alertDialog.setTitle("EXIT APPLICATION");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            alertDialog.create();
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent location=new Intent(MainActivity.this, MainActivity.class);
            startActivity(location);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent location=new Intent(MainActivity.this, NearByActivity.class);
            startActivity(location);
        } else if (id == R.id.nav_slideshow) {
            Intent location=new Intent(MainActivity.this, LocationAlarmActivity.class);
            startActivity(location);
        } else if (id == R.id.nav_manage) {
            Intent location=new Intent(MainActivity.this, DistanceTrackerActivity.class);
            startActivity(location);

        } else if (id == R.id.nav_share) {
            Intent share=new Intent(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT,"Click Link To Download The Job Portal\n"
                    + "https://play.google.com/store/apps/details?id=naukriApp.appModules.login&hl=en" );
            share.setType("text/plain");

            startActivity(Intent.createChooser(share,"Share Via"));

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
