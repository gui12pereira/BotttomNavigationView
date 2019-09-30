package br.com.senai.botttomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        //DEFINIR PARA COMEÇAR COM FRAGMENTO HOME
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }

    //** DETECTAR O CLICK DO BOTTOMNAVIGATIONVIEW **
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment = null;

                    //Determinar qual fragmento será instanciado (criado)
                    if (item.getItemId() == R.id.nav_home){
                        fragment = new HomeFragment();
                    } else if (item.getItemId() == R.id.nav_busca){
                        fragment = new SearchFragment();
                    } else {
                        fragment = new FavoriteFragment();
                    }

                    //Obtendo o gerenciador de fragmento da activity
                    //e através dela, inserir o nosso fragmento no FrameLayout,
                    //que é nosso container de fragments
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                    return true;
                }
            };
}
