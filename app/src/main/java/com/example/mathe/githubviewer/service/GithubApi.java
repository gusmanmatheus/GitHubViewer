package com.example.mathe.githubviewer.service;

import com.example.mathe.githubviewer.model.Repository;
import com.example.mathe.githubviewer.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("users/{user}/repos")
    Call<List<Repository>> getListRepos(
            @Path("user") String user
    );

    @GET("users/{user}")
        Call<User> getUser(
            @Path("user") String user
    );
}
