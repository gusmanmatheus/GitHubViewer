package com.example.mathe.githubviewer;

import android.content.Intent;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mathe.githubviewer.model.RepositorioUsuario;
import com.example.mathe.githubviewer.model.Repository;
import com.example.mathe.githubviewer.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoasDadosActivity extends AppCompatActivity {
    private ImageView fotoUsuario;
    private Button voltar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private LinearLayout linearLayout;
    private List<Repository> repositorioUsuario;
    private ListaAdapter listaAdapter;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoas_dados);
        voltar=findViewById(R.id.botao_Voltar_Id);
        linearLayout=findViewById(R.id.linha_List_Id);
        fotoUsuario=findViewById(R.id.imagem_Foto_Id);
        name =findViewById(R.id.nome_Usuario_Id);

            User user = (User)getIntent().getSerializableExtra("DADOS");
            List  <Repository> repository =(List <Repository>) getIntent().getSerializableExtra("REPO");
        name.setText(user.getName());
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView_Id);
        mRecyclerView.setHasFixedSize(true);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
         repositorioUsuario=repository;

        String urlFoto =user.getImage();
        Glide.with(this).load(urlFoto).apply(RequestOptions.circleCropTransform()).into(fotoUsuario);

        listaAdapter= new ListaAdapter(repositorioUsuario);

        mRecyclerView.setAdapter(listaAdapter);

       // Toast.makeText(MainActivity.this, response.body().getName(), Toast.LENGTH_SHORT).show();



        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PessoasDadosActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
