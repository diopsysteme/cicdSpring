package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Datas.Repository.ApprenantRepository;
import org.SchoolApp.Datas.Repository.ModulesRepository;
import org.SchoolApp.Datas.Repository.NoteRepository;
import org.SchoolApp.Web.Dtos.Request.NoteUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Autowired
    private ModulesRepository modulesRepository;

    public List<NotesEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public NotesEntity addNote(Long apprenantId,float note,Long moduleId){
        NotesEntity noteEntity = new NotesEntity();
        ModulesEntity modules = modulesRepository.findById(moduleId).orElseThrow();
        ApprenantEntity apprenant = apprenantRepository.findById(apprenantId).orElseThrow();


        noteEntity.setNote(note);
        noteEntity.setModule(modules);
        noteEntity.setApprenant(apprenant);
        noteRepository.save(noteEntity);

        return noteEntity;
    }

    public List<NotesEntity> addNotesGroupe(List<NotesEntity> requests){
        for (NotesEntity noteRequest : requests) {
            addNote(noteRequest.getApprenant().getId(),noteRequest.getNote(),noteRequest.getModule().getId());
        }

        return requests;
    }

    public HashSet<NotesEntity> addNotesModules(HashSet<NotesEntity> noteRequest){

        for (NotesEntity note: noteRequest) {
            System.out.println(note);
            ApprenantEntity apprenant = apprenantRepository.findById(note.getApprenant().getId()).orElseThrow();
            addNote(note.getApprenant().getId(),note.getNote(),note.getModule().getId());
        }

        return noteRequest;
    }

    public List<NoteUpdate> updateNotes(List<NoteUpdate> notes) throws Exception {
        if(notes.stream().count() <= 0){
            throw new Exception("tu dois passer au moins une note a mettre a jour");
        }

        for (NoteUpdate note : notes) {
            NotesEntity OneNote = noteRepository.findById(note.getNoteId()).orElseThrow();
            OneNote.setNote(note.getNote());
            noteRepository.save(OneNote);
        }



        return notes;
    }

    public List<NotesEntity> findByReferentiel(Long ReferentielId){
        return noteRepository.findByApprenant_Referentiel_IdAndActivePromo(ReferentielId,EtatEnum.ACTIF);
    }
}
