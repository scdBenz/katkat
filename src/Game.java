import java.util.List;

public class Game {
    List<Gamer> gamers;
    List<Bot> bots;

    boolean status;

    public List<Bot> getBots(){
        return bots;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public void setGamers(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus() {
        return status;
    }
}
