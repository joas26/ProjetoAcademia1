package br.unitins.projetoacademia;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fragmentos.AlunoFragment;
import fragmentos.RVFragment;






public class TelaPrincipal extends AppCompatActivity {

  //  ArrayList<Aluno> dataSource = null;
    TextView usuario = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_principal);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.action_Alunos:
                        Intent intent = new Intent(TelaPrincipal.this,TelaAlunos.class);
                        startActivity(intent);

                        return true;

                    case R.id.action_Inicio:

                        Intent intent1 = new Intent(TelaPrincipal.this,TelaPerfil.class);
                        startActivity(intent1);

                        return true;

                    case R.id.action_Sair:
                        Toast.makeText(TelaPrincipal.this, "Até Logo!!", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(TelaPrincipal.this,TelaLogin.class);
                        startActivity(intent2);
                        return true;


                }


                return false;
            }





        });


    }

}


