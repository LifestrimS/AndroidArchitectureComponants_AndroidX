package ru.lifestrim.mvvm_test.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import ru.lifestrim.mvvm_test.utils.DateConverter;

/**
 * This class will represents note structure in database. Note will have unique id, title,
 * description and created at as shown below.
 */

// Entity class model of room database
@Entity
public class Note {
    // room database entity primary key
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String noteTitle;
    private String noteDescription;

    //type converter for date
    @TypeConverters(DateConverter.class)
    private Date createdAt;

    public Note(String noteTitle, String noteDescription, Date createdAt) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle() {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

