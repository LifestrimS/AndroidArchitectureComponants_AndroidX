package ru.lifestrim.mvvm_test.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.lifestrim.mvvm_test.database.NoteDao;
import ru.lifestrim.mvvm_test.database.NoteDatabase;
import ru.lifestrim.mvvm_test.database.models.Note;

/**
 * This class will serve as true source of data. Create methods to get data from Room database or
 * any other database like firebase. Inside create LiveData of List of all notes and method to add
 * note inside Room Database as shown below.
 */

//Notes repository
public class NotesRepository {
    //Live Data of List of all notes
    private LiveData<List<Note>> mAllNotes;
    //Define Notes Dao
    NoteDao mNoteDao;

    public NotesRepository(@NonNull Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getDatabase(application);
        //init Notes Dao
        mNoteDao = noteDatabase.noteDao();
        //get all notes
        mAllNotes = mNoteDao.getAllNotes();
    }
    //method to get all notes
    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    //method to add note
    public void addNote(Note note) {
        new AddNote().execute(note);
    }

    //Async task to add note
    public class AddNote extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insertNote(notes[0]);
            return null;
        }
    }
}
