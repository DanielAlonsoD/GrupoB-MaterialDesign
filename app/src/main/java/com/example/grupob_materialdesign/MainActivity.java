package com.example.grupob_materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements NavHost {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowMenu = findViewById(R.id.btnShowMenu);
        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.bottom_sheet_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        boolean realizado = false;
                        if (menuItem.getItemId()==R.id.menu_option1) {
                            // Acción para la opción 1
                            realizado = true;
                        } else if (menuItem.getItemId()==R.id.menu_option2) {
                            // Acción para la opción 2
                            realizado = true;
                        } else if (menuItem.getItemId()==R.id.menu_option2) {
                            // Acción para la opción 3
                            realizado = true;
                        }
                        return realizado;
                    }
                });
                popupMenu.show();
            }
        });

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId()==R.id.navigation_home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId()==R.id.navigation_dashboard) {
                    selectedFragment = new Fragmento();
                } else if (item.getItemId()==R.id.navigation_notifications) {
                    selectedFragment = new NotificationsFragment();
                }

                // Muestra el fragmento seleccionado
                showFragment(selectedFragment);

                return true;
            }
        });

        // Muestra el fragmento HomeFragment por defecto
        showFragment(new HomeFragment());
    }

    private void showFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @NonNull
    @Override
    public NavController getNavController() {
        return navController;
    }

}