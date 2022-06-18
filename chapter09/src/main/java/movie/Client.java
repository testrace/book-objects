package movie;

public class Client {

    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatarMovie = factory.createAvatarMovie();
        return avatarMovie.getFee();
    }
}
