package main.java.lekcje.singleton;

public class GameConfig {
    private static volatile GameConfig instance;
    private String serverIp;
    private final int maxPlayers;

    public GameConfig(String serverIp, int maxPlayers){
        this.maxPlayers = maxPlayers;
        this.serverIp = serverIp;
    }

    public static GameConfig getInstance() {
        if (instance == null) {
            synchronized (GameConfig.class) {
                if (instance == null) {
                    instance = new GameConfig("127.0.0.1", 100);
                }
            }
        }
        return instance;
    }
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

}
/*
Słowo volatile zmusza komputer, aby najpierw w 100% zbudował nasz obiekt, a dopiero potem ogłosił reszcie systemu, że jest on gotowy do użycia.
 Dzięki temu mamy gwarancję, że żaden inny wątek omyłkowo nie skorzysta z "niedokończonego" obiektu, co uchroni program przed błędami.
 */
