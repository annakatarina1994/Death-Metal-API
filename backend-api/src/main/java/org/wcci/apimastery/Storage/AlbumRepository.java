package org.wcci.apimastery.Storage;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findById(Long albumToFind);
    Optional<Album> findByTitle(String title);
    Optional<Album> findByLabel(String label);
    Optional<Album> findByArtistName(String artistName);

}
