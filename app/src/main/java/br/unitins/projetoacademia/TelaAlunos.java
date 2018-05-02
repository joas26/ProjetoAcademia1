package br.unitins.projetoacademia;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by labmacmini01 on 04/04/18.
 */

class Adaptador extends RecyclerView.Adapter<ItemHolder>{


    Context contexto = null;
    ArrayList<ItemRecycler> lista = null;

    Adaptador(Context contexto, ArrayList<ItemRecycler> lista ){
        this.contexto = contexto;
        this.lista = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.layout_celula, parent, false);
        ItemHolder item = new ItemHolder(celula);
        return item;
    }

    /*
    * Método que recebe o ViewHolder e a posição da lista.
    * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
    * É onde a mágica acontece!
    * */
    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ItemRecycler item = lista.get(position);

        holder.texto.setText(item.nome);
        holder.imagem.setImageBitmap(BitmapFactory.decodeResource(contexto.getResources(), item.codImagem));

    }

    //METODO QUE DETERMINA QUANTOS ITENS VAI TER NA LISTA
    /*
    * Método que deverá retornar quantos itens há na lista.
    * Aconselha-se verificar se a lista não está nula como no exemplo,
    * pois ao tentar recuperar a quantidade da lista nula pode gerar
    * um erro em tempo de execução (NullPointerException).
    * */
    @Override
    public int getItemCount() {

        return (lista !=null) ?  lista.size() : 0;

    }
}

public class TelaAlunos extends AppCompatActivity {
    ArrayList<ItemRecycler> dataSource = null;
    Button vrBotaoCadastrar ;
    @Override

    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_tela_alunos);


        vrBotaoCadastrar = (Button) findViewById(R.id.TelaAlunoBotaoCadastrar);

        vrBotaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaAlunos.this,TelaCadastroAluno.class);
                startActivity(intent);
            }
        });

        dataSource = new ArrayList<>();
        RecyclerView lista = null;

        dataSource.add(new ItemRecycler("Aluno1", R.drawable.ic_foto1));

        dataSource.add(new ItemRecycler( "Aluno2", R.drawable.ic_foto1));

        dataSource.add(new ItemRecycler( "Aluno3", R.drawable.ic_foto1));

        dataSource.add(new ItemRecycler( "Aluno4", R.drawable.ic_foto1));





        lista = (RecyclerView)findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);
        Adaptador adapt = new Adaptador(this, dataSource);
        lista.setAdapter(adapt);

    }
}
