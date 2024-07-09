import java.util.ArrayList;
import java.util.List;

public class BotService {
    private Game game;

    public BotService(Game game) {
        this.game = game;
    }

    public List<Bot> createBots(){
        ArrayList<Bot> bots = new ArrayList<>();
        bots.add(new Bot("Бот Никита", 1,Classification.SAPER,true));
        bots.add(new Bot("Бот Влад", 2,Classification.TANK,true));
        bots.add(new Bot("Бот Слава", 3,Classification.TANK,true));
        bots.add(new Bot("Бот Иван", 4,Classification.SNIPER,true));
        bots.add(new Bot("Бот Данил", 5,Classification.MEDIC,true));
        bots.add(new Bot("Бот Рыжий", 6,Classification.SAPER,true));
     return bots;
    }


    public Bot findBotById(Integer botId) {
        for (Bot bot : game.getBots()) {
            if (bot.getId().equals(botId)) {
                return bot;
            }
        }
        return null;
    }
}
