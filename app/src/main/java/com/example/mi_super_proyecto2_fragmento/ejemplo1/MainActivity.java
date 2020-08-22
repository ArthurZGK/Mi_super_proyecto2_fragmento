package com.example.mi_super_proyecto2_fragmento.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mi_super_proyecto2_fragmento.R;

public class MainActivity extends AppCompatActivity {

    Spinner mispinner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mispinner = findViewById(R.id.mispinner);
        mispinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0,
                                               View arg1, int i, long l) {
// TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this,(String)mispinner.getSelectedItem() , Toast.LENGTH_SHORT).show();
                        Fragment FragmentoSeleccionado = null;
                        switch (i){
                            case 0:
                                FragmentoSeleccionado= new ListaFragmento();
                                break;
                            case 1:
                                FragmentoSeleccionado= new GridFragmento();
                        }
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.fragmento,FragmentoSeleccionado);
                        transaction.commit();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
                    }
                });

    }
}