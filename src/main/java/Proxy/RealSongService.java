package Proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private final List<Song> songLibrary;

    public RealSongService() {
        songLibrary = new ArrayList<>();
        // Add some initial songs to the library
        songLibrary.add(new Song(1, "Espresso", "Sabrina Carpenter"));
        songLibrary.add(new Song(2, "doomsday", "Lizzy McAlpine"));
        songLibrary.add(new Song(3, "Synthesize Her", "TWRP"));
        songLibrary.add(new Song(4, "Let's Call It Forever", "Mark Barlow"));
        songLibrary.add(new Song(5, "Unstoppable Force", "Heaven Pierce Her"));
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000); // Simulate server delay
        } catch (Exception _) {}

        return songLibrary.stream()
                .filter(song -> song.getSongID().equals(songID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000); // Simulate server delay
        } catch (Exception _) {}

        return songLibrary.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000); // Simulate server delay
        } catch (Exception _) {}

        return songLibrary.stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
}
