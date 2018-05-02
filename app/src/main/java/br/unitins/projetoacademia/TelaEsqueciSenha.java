package br.unitins.projetoacademia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaEsqueciSenha extends AppCompatActivity implements View.OnClickListener {
    Button vrBotaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_esqueci_senha);

        vrBotaoEnviar = (Button) findViewById(R.id.TelaEsqueciSenhaBotaoEnviar);

    }

    @Override
    public void onClick(View view) {
        if (vrBotaoEnviar.getId() == R.id.TelaEsqueciSenhaBotaoEnviar) {
            validaEmail();
        }

    }

    private boolean validaEmail() {
        EditText vrCampoEmail = (EditText) findViewById(R.id.TelaEsqueciSenhaCampoEmail);

        if (vrCampoEmail.getText().toString().equals("usuario@provedor.com")) {

            return true;
        }
        return false;
    }


    public void validaEmail(View vrBotaoEnviar) {

        if (vrBotaoEnviar.getId() == R.id.TelaEsqueciSenhaBotaoEnviar) {


            if (validaEmail()) {
                Toast vrToast = Toast.makeText(this, "Senha enviada para o email cadastrado", Toast.LENGTH_SHORT);
                vrToast.show();
                // volta para a tela de login
                Intent intent = new Intent(TelaEsqueciSenha.this,TelaLogin.class);
                startActivity(intent);


            }else{
                Toast vrToast = Toast.makeText(this, "Dados incorretos ou Email não cadastrado", Toast.LENGTH_SHORT);
                vrToast.show();

            }

        }
    }

}
