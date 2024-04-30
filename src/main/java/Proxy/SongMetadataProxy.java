package Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SongMetadataProxy implements SongService {
    private final RealSongService realSongService;
    private final Map<Integer, Song> songCache;

    public SongMetadataProxy() {
        realSongService = new RealSongService();
        songCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (songCache.containsKey(songID)) {
            return songCache.get(songID);
        } else {
            Song song = realSongService.searchById(songID);
            if (song != null) {
                songCache.put(songID, song);
            }
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> songs = realSongService.searchByTitle(title);
        cacheSongs(songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> songs = realSongService.searchByAlbum(album);
        cacheSongs(songs);
        return songs;
    }

    private void cacheSongs(List<Song> songs) {
        songs.forEach(song -> songCache.put(song.getSongID(), song));
    }
}
