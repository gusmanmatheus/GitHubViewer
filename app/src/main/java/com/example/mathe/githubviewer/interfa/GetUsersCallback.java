package com.example.mathe.githubviewer.interfa;

import com.example.mathe.githubviewer.model.User;

public interface GetUsersCallback {
    void finish(boolean success,User user);
}
