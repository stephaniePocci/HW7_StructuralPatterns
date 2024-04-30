package Proxy;

public class Song {
    private final Integer songID;
    private final String title;
    private final String album;

    public Song(Integer songID, String title, String album) {
        this.songID = songID;
        this.title = title;
        this.album = album;
    }

    public Integer getSongID() {
        return songID;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return STR."Song{songID=\{songID}, title='\{title}\{'\''}, album='\{album}\{'\''}}";
    }
}
