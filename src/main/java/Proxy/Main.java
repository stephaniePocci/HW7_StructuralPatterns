package Proxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongService songService = new SongMetadataProxy();

        // Search by ID
        Song song3 = songService.searchById(3);
        System.out.println(STR."Song 1: \{song3}");

        // Search by Title
        List<Song> songsByTitle = songService.searchByTitle("Espresso");
        System.out.println(STR."Songs with Title 'Espresso': \{songsByTitle}");

        // Search by Album
        List<Song> songsByAlbum = songService.searchByAlbum("Unstoppable Force");
        System.out.println(STR."Songs in Album 'TWRP': \{songsByAlbum}");
    }
}
