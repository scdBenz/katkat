import java.util.List;

public class GameService {

    private Game game;

    public GameService(Game game) {
        this.game = game;
    }
    void showMenu(){
        System.out.println();
        System.out.println("Меню администратора:");
        System.out.println("1. Показать список игроков");
        System.out.println("2. Отключить звук для игрока");
        System.out.println("3. Исключить игрока");
        System.out.println("4. Изменить класс игрока");
        System.out.println("5. Завершить игру");
        System.out.print("Введите номер команды: ");
    }

    void stratGame(){
        GamerService gamerService = new GamerService(game);
        BotService botService = new BotService(game);
        List<Gamer> gamers = gamerService.createGamers();
        List<Bot> bots = botService.createBots();
        game.setBots(bots);
        game.setGamers(gamers);
        turnOn();
    }
    public void turnOn(){
        game.setStatus(true);
    }

    public void turnOff(){
        game.setStatus(false);
    }

    public boolean isOn(){
        return game.getStatus();
    }
}
