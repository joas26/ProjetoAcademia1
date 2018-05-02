package br.unitins.projetoacademia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCadastroAluno extends AppCompatActivity {

    Button vrBotaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_cadastro_aluno);


        vrBotaoVoltar = (Button) findViewById(R.id.TelaCadastroBotaoVoltar);
        vrBotaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadastroAluno.this,TelaPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
