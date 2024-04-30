import Proxy.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    @Test
    public void testSongConstructor() {
        Integer songID = 1;
        String title = "Hello";
        String album = "Greatest Hits";

        Song song = new Song(songID, title, album);

        assertEquals(songID, song.getSongID());
        assertEquals(title, song.getTitle());
        assertEquals(album, song.getAlbum());
    }

    @Test
    public void testGetSongID() {
        Integer songID = 2;
        String title = "Goodbye";
        String album = "Classics";

        Song song = new Song(songID, title, album);

        assertEquals(songID, song.getSongID());
    }

    @Test
    public void testGetTitle() {
        Integer songID = 3;
        String title = "Love Song";
        String album = "Ballads";

        Song song = new Song(songID, title, album);

        assertEquals(title, song.getTitle());
    }

    @Test
    public void testGetAlbum() {
        Integer songID = 4;
        String title = "Rockin' Tune";
        String album = "Rock Anthems";

        Song song = new Song(songID, title, album);

        assertEquals(album, song.getAlbum());
    }

    @Test
    public void testToString() {
        Integer songID = 5;
        String title = "Classic Hit";
        String album = "Oldies";

        Song song = new Song(songID, title, album);

        String expected = "Song{songID=5, title='Classic Hit', album='Oldies'}";
        assertEquals(expected, song.toString());
    }
}