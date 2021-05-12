package com.example.injectoreskotlin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.injectoreskotlin.model.Repo
import com.example.injectoreskotlin.model.RepoSearchResult
import com.example.injectoreskotlin.model.User

@Database(
    entities = [
        User::class,
        Repo::class,
//        Contributor::class,
        RepoSearchResult::class
    ], version = 1)
abstract class GithubDb: RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun repoDao(): RepoDao
}