package net.eldiosantos.viajabessa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import net.eldiosantos.viajabessa.fragment.ListaPacotesFragment;
import net.eldiosantos.viajabessa.util.Logger;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.log("MainActivity.onCreate...");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, new ListaPacotesFragment())
                .commit();
        Logger.log("MainActivity.onCreate.");
    }
}
