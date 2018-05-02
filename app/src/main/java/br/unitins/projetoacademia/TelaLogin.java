package br.unitins.projetoacademia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener {
    Button vrBotaoOk;
    TextView esquecisenha;

    EditText etUsuario;
    EditText etSenha;


    public static final String PREFS_NAME = "Preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_login);

        vrBotaoOk = (Button) findViewById(R.id.TelaLoginbotaoOk);
        esquecisenha = (TextView) findViewById(R.id.TelaLoginEsqueciASenha);

        etUsuario = (EditText)findViewById(R.id.TelaLogincampoLogin);
        etSenha = (EditText)findViewById(R.id.TelaLogincampoSenha);

        //Restaura as preferencias gravadas
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        etUsuario.setText(settings.getString("PrefUsuario", ""));



        esquecisenha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this,TelaEsqueciSenha.class);
                startActivity(intent);
            }
        });


    }


    /**Chamado quando a Activity é encerrada.*/
    @Override
    protected void onStop(){
        super.onStop();

        //Caso o checkbox esteja marcado gravamos o usuário
        CheckBox chkSalvar = (CheckBox)findViewById(R.id.TelaLoginLembrar);
        if (chkSalvar.isChecked()){
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("PrefUsuario", etUsuario.getText().toString());

            //Confirma a gravação dos dados
            editor.commit();
        }
    }


    @Override
    public void onClick(View view) {
        if (vrBotaoOk.getId() == R.id.TelaLoginbotaoOk){
            validaLogin();
        }

    }

    //Metodo utilizado para validar login e senha
    private boolean validaLogin(){
        EditText vrCampoLogin = (EditText)findViewById(R.id.TelaLogincampoLogin);
        EditText vrCampoSenha = (EditText) findViewById(R.id.TelaLogincampoSenha);

        if (vrCampoLogin.getText().toString().equals("usuario") && vrCampoSenha.getText().toString().equals("1234")){

            return true;
        }
        return false;
    }


    //Metodo utilizado para capturar eventos do botao
    public void validaLogin(View vrBotaoOk){
        if (vrBotaoOk.getId() == R.id.TelaLoginbotaoOk){

            if (validaLogin()){

                EditText vrCampoLogin = (EditText)findViewById(R.id.TelaLogincampoLogin);

                Bundle dicionario = new Bundle();
                dicionario.putString("login", vrCampoLogin.getText().toString());
                dicionario.putInt("idade", 45);
                dicionario.putChar("sexo", 'f');

                //troca de tela para o perfil do usuario
                Intent intentPerfilUsuario = new Intent(TelaLogin.this, TelaPrincipal.class);
                intentPerfilUsuario.putExtras(dicionario);
                startActivityForResult(intentPerfilUsuario,1);



            }
            else {
                Toast vrToast = Toast.makeText(this, "Login ou Senha incorretos! Verifique.", Toast.LENGTH_SHORT);
                vrToast.show();
            }
        }

    }

    public void EsqueciAsenha(View esqueciSenha){

        if (esqueciSenha.getId() == R.id.TelaLoginEsqueciASenha) {

        }
    }


    public void onActivityResult(int codigo, int resultado, Intent intencao){
        if (resultado == Activity.RESULT_OK){
            if (codigo == 1){

            }
        }
    }


}
