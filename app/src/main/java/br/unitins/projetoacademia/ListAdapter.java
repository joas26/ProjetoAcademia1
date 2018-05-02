package br.unitins.projetoacademia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import br.unitins.projetoacademia.Aluno;

/**
 * Created by joas2 on 24/04/2018.
 */

public class ListAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_celula,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Aluno.nome.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imagem;
        private TextView nome;

        public ListViewHolder( View itemView){
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nomeAluno);
            imagem = (ImageView) itemView.findViewById(R.id.imagemAluno);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            nome.setText(Aluno.nome[position]);
            imagem.setImageResource(Aluno.imagem[position]);

        }


            public void onClick(View view) {

            }
        }


}
