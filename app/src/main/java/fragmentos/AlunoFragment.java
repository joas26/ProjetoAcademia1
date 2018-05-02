package fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import br.unitins.projetoacademia.ListAdapter;
import br.unitins.projetoacademia.R;


public class AlunoFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.layout_celula,container,false);

        /*
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclewAlunos1);

        ListAdapter listAdapter;
        listAdapter = new ListAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(layoutManager);

        */
        return  view;
        }


    }


