package SpaceX05;

public interface Commons {
    int BOARD_WIDTH = Settings.getInstance().Board_Width;
    int BOARD_HEIGTH = Settings.getInstance().Board_Height;
    int DELAY = 17;
    ThreadLocal<String> SERVER_IP = ThreadLocal.withInitial(() -> "localhost");
    int PLAYER_WIDTH = 15;
    int PLAYER_HEIGHT = 10;
    int NUMBER_OF_ALIENS_TO_DESTROY = 27;
    int ALIEN_HEIGHT = 12;
    int ALIEN_WIDTH = 12;
    int GROUND = 290;
}
