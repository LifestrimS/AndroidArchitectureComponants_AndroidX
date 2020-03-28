package ru.lifestrim.mvvm_test.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import java.util.List;

import ru.lifestrim.mvvm_test.database.models.Note;
import ru.lifestrim.mvvm_test.utils.DateConverter;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Define Methods to insert, delete, getting all notes as shown below.
 */
//note dao(data access object)
@Dao
@TypeConverters(DateConverter.class)
public interface NoteDao {
    // Dao method to get all notes
    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllNotes();

    // Dao method to insert note
    @Insert(onConflict = REPLACE)
    void insertNote(Note note);

    // Dao method to delete note
    @Delete
    void deleteNote(Note note);
}
