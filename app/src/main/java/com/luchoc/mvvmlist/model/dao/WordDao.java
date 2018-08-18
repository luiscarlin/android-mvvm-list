package com.luchoc.mvvmlist.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.luchoc.mvvmlist.model.entity.Word;

import java.util.List;

/**
 * Notes:
 *
 * DAO -> Data Access Object
 * - specifies SQL statements to access your data from methods
 * - must be an interface or abstract class
 * - all queries are done in a separate field
 */

// Dao class for Room
@Dao
public interface WordDao {

    // convenience method to insert a Word (auto generated SQL)
    // other convenience methods include @Update a Word and @Delete a Word
    // if conflict happens (2 items with same primary key), it will ABORT by default
    // you can specify other conflict strategies. ex: @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    void insert(Word word);

    // Delete all the Words by running this query
    @Query("DELETE FROM word_table")
    void deleteAll();


    // Get all words by running this query
    @Query("SELECT * from word_table ORDER BY word ASC")
    List<Word> getAllWords();
}
