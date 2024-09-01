package eu.projects.fridarik.easysalemetafetcher.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import eu.projects.fridarik.easysalemetafetcher.database.AppDB;
import eu.projects.fridarik.easysalemetafetcher.database.UserDao;
import eu.projects.fridarik.easysalemetafetcher.database.UserEntity;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<UserEntity>> allUsers;
    private ExecutorService executorService;

    public UserRepository(Application application) {
        AppDB database = AppDB.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
        executorService = Executors.newFixedThreadPool(2);
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return allUsers;
    }

    public void insert(UserEntity user) {
        executorService.execute(() -> userDao.insert(user));
    }

    public void update(UserEntity user) {
        executorService.execute(() -> userDao.update(user));
    }

    public void delete(UserEntity user) {
        executorService.execute(() -> userDao.delete(user));
    }
}
