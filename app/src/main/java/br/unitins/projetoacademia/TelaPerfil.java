package br.unitins.projetoacademia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPerfil extends AppCompatActivity {

    Button vrBotaoVoltar;
    Button vrBotaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_perfil);

        vrBotaoVoltar = (Button) findViewById(R.id.TelaPerfilBotaoVoltar);
        vrBotaoSalvar = (Button) findViewById(R.id.TelaPerfilBotaoSalvar);

        vrBotaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPerfil.this,TelaPrincipal.class);
                startActivity(intent);
            }
        });

    }
}
