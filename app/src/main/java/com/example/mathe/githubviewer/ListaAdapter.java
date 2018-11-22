package com.example.mathe.githubviewer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mathe.githubviewer.model.RepositorioUsuario;
import com.example.mathe.githubviewer.model.Repository;

import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter <ListaAdapter.ViewHolderLista> {
    private List<Repository> dados;

    public ListaAdapter(List<Repository> dados){
        this.dados=dados;

    }


    @NonNull
    @Override
    public ListaAdapter.ViewHolderLista onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater =LayoutInflater.from(viewGroup.getContext());
        View view =layoutInflater.inflate(R.layout.linha_lista,viewGroup,false);
        ViewHolderLista viewHolderLista = new ViewHolderLista(view);
        return viewHolderLista;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.ViewHolderLista viewHolder, int i) {
       if((dados!=null)&&(dados.size()>0)){
            Repository  repository = dados.get(i);
            viewHolder.nomeRepositorio.setText(repository.getName());
            viewHolder.linguagemRepositorio.setText(repository.getLanguage());
        }

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderLista extends RecyclerView.ViewHolder{

    public TextView nomeRepositorio;
    public TextView linguagemRepositorio;
    public ViewHolderLista(View itemView){
            super(itemView);

            nomeRepositorio= itemView.findViewById(R.id.txt_NomeProjeto_Id);
            linguagemRepositorio=itemView.findViewById(R.id.linguagemProjeto_Id);
        }
    }
}
