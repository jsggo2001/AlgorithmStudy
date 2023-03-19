package proxy;

public class Client {
    public static void main(String[] args) {
        GameService service = new GameServiceProxy();
        service.startGame();
    }
}
