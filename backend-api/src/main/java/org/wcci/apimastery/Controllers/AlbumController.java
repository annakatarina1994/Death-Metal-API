package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Song;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumStorage albumStorage;
    private SongStorage songStorage;

    public AlbumController(AlbumStorage albumStorage, SongStorage songStorage) {
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
    }

    @GetMapping
    public Collection<Album> retrieveAlbums() {
        return albumStorage.findAllAlbums();
    }

    @GetMapping("/{title}")
    public Album showAlbumByTitle(@PathVariable String title){
        Optional<Album> retrievedAlbum = albumStorage.findByAlbumTitle(title);
    
        return retrievedAlbum.orElse(null);
    }
    
    @GetMapping("/artist/{albumArtist}")
    public Album showAlbumByArtist(@PathVariable String albumArtist) {
        Optional<Album> retrievedAlbum = albumStorage.findAlbumByArtistName(albumArtist);
        
        return retrievedAlbum.orElse(null);
    }
    
    @GetMapping("/label/{albumLabel}")
    public Album showAlbumByLabel(@PathVariable String albumLabel) {
        Optional<Album> retrievedAlbum = albumStorage.findByAlbumLabel(albumLabel);
        
        return retrievedAlbum.orElse(null);
    }
    
    @GetMapping("/song/{songTitle}")
    public Album showAlbumBySongTitle(@PathVariable String songTitle) {
        Optional<Song> retrievedSong = songStorage.findSongByTitle(songTitle);
        
        return retrievedSong.map(Song::getAlbum).orElse(null);
    }
}
