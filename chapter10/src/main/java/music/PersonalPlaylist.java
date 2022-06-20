package music;

public class PersonalPlaylist extends Playlist {

    public void remove(Song song) {
        getTracks().remove(song);
    }
}
