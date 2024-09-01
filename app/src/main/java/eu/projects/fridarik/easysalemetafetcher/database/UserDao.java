package eu.projects.fridarik.easysalemetafetcher.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity user);

    @Update
    void update(UserEntity user);

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM users")
    LiveData<List<UserEntity>> getAllUsers();
}
