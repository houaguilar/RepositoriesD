package com.example.injectoreskotlin.model

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.injectoreskotlin.db.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)
class RepoSearchResult(
    val query: String,
    val reporIds: List<Int>,
    val totalCount: Int,
    val next: Int?
)