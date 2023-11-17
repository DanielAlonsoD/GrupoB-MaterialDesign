package com.example.grupob_materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button btnShowMenu = findViewById(R.id.btnShowMenu);
        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });*/

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
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

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    if (item.getItemId()==R.id.menu_option1) {
                        selectedFragment = new HomeFragment();
                    } else if (item.getItemId()==R.id.menu_option2) {
                        selectedFragment = new DashboardFragment();
                    } else if (item.getItemId()==R.id.menu_option2) {
                        selectedFragment = new NotificationsFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();

                    return true;
                }
            };
}