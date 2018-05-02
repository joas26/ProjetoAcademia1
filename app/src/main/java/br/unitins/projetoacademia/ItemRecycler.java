package br.unitins.projetoacademia;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by labmacmini01 on 04/04/18.
 */
class ItemHolder extends RecyclerView.ViewHolder{

    ImageView imagem = null;
    TextView texto = null;



    ItemHolder(View view){
        super(view);
        imagem = (ImageView)view.findViewById(R.id.imagemAluno);
        texto = (TextView)view.findViewById(R.id.nomeAluno);

        //classificacao.setEnabled(false);
    }
}

public class ItemRecycler {
    String nome;
    int codImagem;

    ItemRecycler( String pNome, int pCod){

        nome = pNome;
        codImagem = pCod;

    }
}
