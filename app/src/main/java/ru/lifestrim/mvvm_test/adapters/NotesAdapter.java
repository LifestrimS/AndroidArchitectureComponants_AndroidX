package ru.lifestrim.mvvm_test.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.lifestrim.mvvm_test.R;
import ru.lifestrim.mvvm_test.database.models.Note;
import ru.lifestrim.mvvm_test.utils.DateConverter;

/**
 * This class will serve as adapter for recyclerview. Create viewholder and bind data to the view
 * inside onCreateViewHolder() and onBindViewHolder() methods respectively as shown below.
 */

public class NotesAdapter extends RecyclerView.Adapter {
    //Create list of notes
    List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Get layout inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //Inflate layout
        View row = inflater.inflate(R.layout.custom_row_note, parent, false);
        //return notes holder and pass row inside
        return new NoteHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Get current note
        Note currentNote = notes.get(position);
        //cast notes holder
        NoteHolder noteHolder = (NoteHolder) holder;
        //set title description and created at
        noteHolder.mNoteTitle.setText(currentNote.getNoteTitle());
        noteHolder.mNoteDescription.setText(currentNote.getNoteDescription());
        noteHolder.createdAt.setText(DateConverter.getDayMonth(currentNote.getCreatedAt()));
        //create random color and set it
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        noteHolder.backStrip.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        TextView mNoteTitle, mNoteDescription, createdAt;
        FrameLayout backStrip;

        public NoteHolder(View itemView) {
            super(itemView);
            mNoteTitle = itemView.findViewById(R.id.noteTitle);
            mNoteDescription = itemView.findViewById(R.id.noteDescription);
            createdAt = itemView.findViewById(R.id.createdAt);
            backStrip = itemView.findViewById(R.id.backStrip);
        }
    }

    public void addNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }
}
