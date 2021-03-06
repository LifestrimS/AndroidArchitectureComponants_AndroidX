package ru.lifestrim.mvvm_test.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.lifestrim.mvvm_test.database.models.Note;

/**
 * This class used to create instance of Room Database. Inside this class provide all entities and
 * dao’s. Structure of this class is as shown below.
 */

@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    //define static instance
    private static NoteDatabase mInstance;

    //method to get room database
    public static NoteDatabase getDatabase(Context context) {

        if (mInstance == null)
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "notes_db")
                    .build();

        return mInstance;
    }

    //method to remove instance
    public static void closeDatabase() {
        mInstance = null;
    }

    //define note dao ( data access object )
    public abstract NoteDao noteDao();
}