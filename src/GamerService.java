import java.util.ArrayList;
import java.util.List;

public class GamerService {
    private Game game;


    public GamerService(Game game) {
        this.game = game;
    }

    public List<Gamer> createGamers(){
        ArrayList<Gamer> gamers = new ArrayList<>();
        gamers.add(new Gamer("Lox", 1111, Classification.MEDIC, false));
        gamers.add(new Gamer("Nagibator", 1112, Classification.SAPER, false));
        gamers.add(new Gamer("Pro", 1113, Classification.SNIPER, false));
        gamers.add(new Gamer("Max", 1114, Classification.TANK, false));
        return gamers;
    }
    public void showGamersInfo(){
        for (Gamer gamer : game.getGamers()) {
            System.out.println(gamer.toString());
        }
    }
    public Gamer findGamerById(Integer id){
        for (Gamer gamer : game.getGamers()) {
            if(gamer.getId().equals(id)){
                return gamer;
            }

        }
        return null;
    }

    public Gamer findGamerByClassification(Classification classification){
        for (Gamer gamer : game.getGamers()) {
            if(gamer.getClassification().equals(classification)){
                return gamer;
            }
        }
        return null;
    }


    /**
     * Удаляет игрока с активной игры
     * @param gamerId id игрока
     */
    public void kickGamer(Integer gamerId){
        Gamer gamerById = findGamerById(gamerId);
        game.getGamers().remove(gamerById);
    }

    /**
     * Отключает микрофон у игрока
     * @param gamerId id игрока
     */
    public void muteGamer(Integer gamerId){
        Gamer gamerById = findGamerById(gamerId);
        gamerById.setMute(true);
    }

    /**
     * Меняет Classification игрока по id. Если данный classification был у другого игрока,
     * то второму игроку присваивается classification первого игрока.
     * @param gamerId id игрока
     * @param classificationName класс игрока
     */
    public void toChangeClassGamer(Integer gamerId, String classificationName){
        ClassificationService classificationService = new ClassificationService();
        Classification classificationByName = classificationService.findClassificationByName(classificationName);

        Gamer gamerById = findGamerById(gamerId);
        Gamer gamerByClassification = findGamerByClassification(classificationByName);

        if(gamerByClassification != null){
            gamerByClassification.setClassification(gamerById.getClassification());
        }
        gamerById.setClassification(classificationByName);
    }


    public void updateGamersList(int botId, Integer gamerId){
        BotService botService = new BotService(game);
        Bot botById = botService.findBotById(botId);
        Gamer gamerById = findGamerById(gamerId);
        botById.setClassification(gamerById.getClassification());
        game.getGamers().add(botById);
        game.getBots().remove(botById);
    }


}
