package com.luchoc.mvvmlist.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.luchoc.mvvmlist.model.dao.WordDao;
import com.luchoc.mvvmlist.model.entity.Word;

/**
 * Room DB
 * - Lies on top of SQLite server
 * - Uses DAO queries
 * - Compile-time checks on queries
 * - Usually one instance for the whole app
 */

// this is a database, entities that belong in the DB (creates all tables), set version number
// By default, it will destroy and recreate the DB.
// For production, you want to provide a way to migrate data when the schema changes. Also update version.
@Database(entities = {Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    /**
     * Create singleton for this class as we only need one
     */
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Define all DAOs associated to this DB
     */
    // getter for WordDao
    public abstract WordDao wordDao();
}
