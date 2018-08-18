package com.luchoc.mvvmlist.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Notes:
 *
 * You can auto-generate private keys (ids) as follows
 * @PrimaryKey(autoGenerate = true)
 * private int id;
 */

// All room annotations found here => https://developer.android.com/reference/android/arch/persistence/room/package-summary
// Entity = table in database
// if no tableName is provided, name of the class will be the name of the table
@Entity(tableName = "word_table")
public class Word {

    // word becomes primary key (cannot be duplicated).
    @PrimaryKey
    // Cannot be null
    @NonNull
    // name of the column in the DB will be word
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) {
        this.mWord = word;
    }

    // mWord needs to be either public or have a getter
    public String getWord(){
        return this.mWord;
    }
}



