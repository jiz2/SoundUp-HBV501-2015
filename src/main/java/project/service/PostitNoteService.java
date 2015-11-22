package project.service;

import project.persistence.entities.PostitNote;

import java.util.List;

public interface PostitNoteService {

    /**
     * Save a {@link PostitNote}
     * @param postitNote {@link PostitNote} to be saved
     * @return {@link PostitNote} that was saved
     */
    PostitNote save(PostitNote postitNote);

    /**
     * Delete {@link PostitNote}
     * @param postitNote {@link PostitNote} to be deleted
     */
    void delete(PostitNote postitNote);

    /**
     * Get all {@link PostitNote}s
     * @return A list of {@link PostitNote}s
     */
    List<PostitNote> findAll();

    /**
     * Get all {@link PostitNote}s in a reverse order
     * @return A reversed list of {@link PostitNote}s
     */
    List<PostitNote> findAllReverseOrder();

    /**
     * Find a {@link PostitNote} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link PostitNote} with {@link Long id}
     */
    PostitNote findOne(Long id);

    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    List<PostitNote> findByName(String name);

}
