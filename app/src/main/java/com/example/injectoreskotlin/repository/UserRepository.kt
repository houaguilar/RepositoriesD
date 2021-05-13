package com.example.injectoreskotlin.repository

import androidx.lifecycle.LiveData
import com.example.injectoreskotlin.AppExecutors
import com.example.injectoreskotlin.api.ApiResponse
import com.example.injectoreskotlin.api.GithubApi
import com.example.injectoreskotlin.db.UserDao
import com.example.injectoreskotlin.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val githubApi: GithubApi
){
    fun loadUser(login: String): LiveData<Resource<User>>{
        return object: NetworkBoundResource<User, User>(appExecutors){
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }

            override fun shouldFetch(data: User?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<User> {
                return userDao.findByLogin(login)
            }

            override fun createCall(): LiveData<ApiResponse<User>> {
                return githubApi.getUser(login)
            }

        }.asLiveData()
    }
}