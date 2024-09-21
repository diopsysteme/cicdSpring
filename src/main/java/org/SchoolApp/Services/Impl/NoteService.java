package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Datas.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Void getAllNotes() {
        List<NotesEntity> notes = noteRepository.findAll();

        for (NotesEntity note : notes) {
            System.out.println("Note: " + note.getNote());
            System.out.println("module: "+ note.getModule().getNom() );
        }

        return null;
    }
}
