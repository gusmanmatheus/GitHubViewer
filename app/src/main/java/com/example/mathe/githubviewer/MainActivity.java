package com.example.mathe.githubviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mathe.githubviewer.model.RepositorioUsuario;
import com.example.mathe.githubviewer.model.Repository;
import com.example.mathe.githubviewer.model.User;
import com.example.mathe.githubviewer.service.GithubApi;
import com.example.mathe.githubviewer.service.ServiceProvider;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button search;
    private EditText nomeProcurado;
    private FrameLayout frameLayout;
    private boolean s =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = findViewById(R.id.botao_Search_Id);
        nomeProcurado = findViewById(R.id.nome_Procurado_Id);
        frameLayout= findViewById(R.id.mvsPbLoading);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                frameLayout.setVisibility(View.VISIBLE);
               final Intent i = new Intent(MainActivity.this, PessoasDadosActivity.class);
                nomeProcurado.getText().toString();

                ServiceProvider.getRetrofit()
                        .create(GithubApi.class)
                        .getUser(nomeProcurado.getText().toString())
                        .enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if(response.isSuccessful()) {
                                    s=true;
                                    //frameLayout.setVisibility(View.GONE);
                                    i.putExtra("DADOS",response.body());
                                    Toast.makeText(MainActivity.this,response.body().getName(),Toast.LENGTH_SHORT).show();
                                } else {                                //    frameLayout.setVisibility(View.GONE);
                                    Log.i("GITHUB", "Deu ruim");
                                    Toast.makeText(MainActivity.this,"Usuario Não Encontrado", Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "Verifique a sua conexão com a internet", Toast.LENGTH_SHORT).show();
                                Log.i("GITHUB", "Deu ruim");


                            }
                        });

                 ServiceProvider.getRetrofit()
                        .create(GithubApi.class)
                        .getListRepos(nomeProcurado.getText().toString())
                        .enqueue(new Callback<List<Repository>>() {
                            @Override
                            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                                if(response.isSuccessful()) {
                                    frameLayout.setVisibility(View.GONE);
                                    i.putExtra("REPO",(Serializable)response.body());
                                    startActivity(i);

                                } else {
                                    frameLayout.setVisibility(View.GONE);
                                    Toast.makeText(MainActivity.this,"Sem Repositorios",Toast.LENGTH_SHORT).show();

                                    Log.i("GITHUB", "Deu ruim");

                                }

                            }

                            @Override
                            public void onFailure(Call<List<Repository>>call, Throwable t) {
                                Toast.makeText(MainActivity.this, "Verifique a sua conexão com a internet", Toast.LENGTH_SHORT).show();

                                Log.i("GITHUB", "Deu ruimz");
                                frameLayout.setVisibility(View.GONE);
                            }
                        });




                        }//click

        });//onclick


    }//oncreate
}//class
