package algorithm.mhernandez.petagram;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

import algorithm.mhernandez.petagram.adapter.PageAdapter;
import algorithm.mhernandez.petagram.fragment.PerfilFragment;
import algorithm.mhernandez.petagram.fragment.PrincipalFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar) findViewById(R.id.toolbar);
        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new PrincipalFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_doggy);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_favorite:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Intent intentc = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intentc);
                return true;
            case R.id.action_about:
                Intent intenta = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intenta);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}