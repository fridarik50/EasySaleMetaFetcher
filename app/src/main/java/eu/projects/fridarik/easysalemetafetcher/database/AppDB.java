package eu.projects.fridarik.easysalemetafetcher.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 2)
public abstract class AppDB extends RoomDatabase {

    private static AppDB instance;

    public abstract UserDao userDao();

    public static synchronized AppDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
