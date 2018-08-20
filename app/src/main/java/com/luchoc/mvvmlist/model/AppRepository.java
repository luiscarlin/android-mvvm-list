package com.luchoc.mvvmlist.model;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.luchoc.mvvmlist.model.dao.WordDao;
import com.luchoc.mvvmlist.model.entity.Word;

import java.util.List;

/**
 * - Abstracts the Database, so that it can be swapped faster
 * - It is suggested as best practice
 * - Provides a clean API for the rest of the app to use
 * - It can have logic that chooses to fetch data for network or use local cached data from database
 */
public class AppRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


    // Constructor
    AppRepository(Application application) {
        // get a hold of the database
        AppDatabase db = AppDatabase.getDatabase(application);

        // initialize member vars
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    // API to access getAllWords from DAO
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // API to insert a word
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    // Insert Async Task class
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
