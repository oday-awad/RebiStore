package net.rebi.estore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import net.rebi.estore.OnItemsRecyclerViewClickListener;
import net.rebi.estore.R;
import net.rebi.estore.classes.items_class;
import net.rebi.estore.fragments.CartFragment;
import net.rebi.estore.fragments.MainFragment;

import java.util.List;
import java.util.Objects;


public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager     fragmentManager;
    FragmentTransaction fragmentTransaction;
    private long mBackPressed1;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        getWindow ( ).addFlags ( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
        setContentView ( R.layout.main );

        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );

        FloatingActionButton fab = findViewById ( R.id.fab );
        fab.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Snackbar.make ( view , "Replace with your own action" , Snackbar.LENGTH_LONG ).setAction ( "Action" , null ).show ( );
            }
        } );

        DrawerLayout   drawer         = findViewById ( R.id.drawer_layout );
        NavigationView navigationView = findViewById ( R.id.nav_view );
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle ( this , drawer , toolbar ,
                                            R.string.navigation_drawer_open ,
                                            R.string.navigation_drawer_close );
        drawer.addDrawerListener ( toggle );
        toggle.syncState ( );
        navigationView.setNavigationItemSelectedListener ( this );

        fragmentManager = getSupportFragmentManager ( );
        open ( );

    }

    @Override
    public void onBackPressed ( ) {
        DrawerLayout drawer = findViewById ( R.id.drawer_layout );
        if ( drawer.isDrawerOpen ( GravityCompat.START ) ) {
            drawer.closeDrawer ( GravityCompat.START );
        }
        else {
            for ( int i = 0 ; i < fragmentManager.getFragments ( ).size ( ) ; i++ ) {
                System.err.println ( fragmentManager.getFragments ( ).get ( i ).getTag ( ) );
            }
            if ( fragmentManager.getBackStackEntryCount ( ) == 1 ) {
                if ( mBackPressed1 + 2000 > System.currentTimeMillis ( ) ) {
                    finish ( );
                }
                else {
                    Toast.makeText ( this , getString ( R.string.PleaseClickBACKAgain ) ,
                                     Toast.LENGTH_SHORT ).show ( );
                }
                mBackPressed1 = System.currentTimeMillis ( );
            }
            else {
                super.onBackPressed ( );
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        // Inflate the menu; this adds main to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.main_menu , menu );

        //Start Notification Count
        //        MenuItem menuItem            = menu.findItem ( R.id.action_notifications );
        //        View     view                = menuItem.getActionView ( );
        //        TextView notifications_count = view.findViewById ( R.id.notifications_count );
        //        notifications_count.setText ( "9+" );
        //End Notification Count


        return true;
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {
        // Handle action bar item_schema clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        if ( id == R.id.action_Main ) {
            openMainFragment ( );
        }
        if ( id == R.id.action_cart ) {
            openCartFragment ( );
        }


        return super.onOptionsItemSelected ( item );
    }

    @Override
    public boolean onNavigationItemSelected ( MenuItem item ) {
        // Handle navigation view item_schema clicks here.
        int id = item.getItemId ( );


        switch ( id ) {
            case R.id.nav_home:
                openMainFragment ( );
                break;
            case R.id.nav_cart:

                openCartFragment ( );
                break;
            case R.id.nav_login:
                openSectionActivity ( "1" );

                break;
            case R.id.nav_tools:
                Toast.makeText ( this , "nav_tools" , Toast.LENGTH_SHORT ).show ( );

                break;
            case R.id.nav_share:
                Toast.makeText ( this , "nav_share" , Toast.LENGTH_SHORT ).show ( );

                break;
            case R.id.nav_send:
                Toast.makeText ( this , "nav_send" , Toast.LENGTH_SHORT ).show ( );

                break;
        }

        DrawerLayout drawer = findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );
        return true;
    }


    public void openMainFragment ( ) {
        List < Fragment > frags = fragmentManager.getFragments ( );
        if ( ! Objects.equals ( frags.get ( frags.size ( ) - 1 ).getTag ( ) , "MAIN_FRAGMENT" ) ) {
            open ( );
        }
    }

    public void open ( ) {
        fragmentTransaction = fragmentManager.beginTransaction ( );
        MainFragment MainFragment = new MainFragment ( new OnItemsRecyclerViewClickListener ( ) {
            @Override
            public void onItemClick ( String id ) { openSectionActivity ( id ); }

            @Override
            public void onItemClick ( items_class selected_item ) {
                Intent intent = new Intent ( getBaseContext ( ) , Details.class );
                intent.putExtra ( "selected_item" , selected_item );
                startActivity ( intent );
            }
        } );
        fragmentTransaction.replace ( R.id.main_content_fragment , MainFragment , "MAIN_FRAGMENT" );
        fragmentTransaction.addToBackStack ( null );
        fragmentTransaction.commit ( );
    }

    public void openCartFragment ( ) {
        List < Fragment > frags = fragmentManager.getFragments ( );
        if ( ! Objects.equals ( frags.get ( frags.size ( ) - 1 ).getTag ( ) , "CART_FRAGMENT" ) ) {
            fragmentTransaction = fragmentManager.beginTransaction ( );
            CartFragment cartFragment = new CartFragment ( );
            fragmentTransaction.replace ( R.id.main_content_fragment , cartFragment ,
                                          "CART_FRAGMENT" );
            fragmentTransaction.addToBackStack ( null );
            fragmentTransaction.commit ( );
        }
    }

    public void openSectionActivity ( String id ) {
        Intent intent = new Intent ( this , Sections.class );
        intent.putExtra ( "id" , id );
        startActivity ( intent );
    }

}
