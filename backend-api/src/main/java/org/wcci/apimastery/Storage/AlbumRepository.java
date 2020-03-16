package org.wcci.apimastery.Storage;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findById(Long albumToFind);
    
}