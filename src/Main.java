import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Random random = new Random();


        Game game = new Game();
        GamerService gamerService = new GamerService(game);
        GameService gameService = new GameService(game);
        gameService.stratGame();

        while (gameService.isOn()){
            gameService.showMenu();
            int number = scr.nextInt();
            if(number == 1){
                gamerService.showGamersInfo();
            }
            if(number == 2){
                System.out.print("Введите id игрока: ");
                int gamerId = scr.nextInt();
                gamerService.muteGamer(gamerId);
                gamerService.showGamersInfo();
            }
            if(number == 3){
                System.out.print("Введите id игрока: ");
                int gamerId = scr.nextInt();
                int botId = random.nextInt(6)+1;
                gamerService.updateGamersList(botId,gamerId);
                gamerService.kickGamer(gamerId);
                gamerService.showGamersInfo();
            }
            if(number == 4){
                System.out.print("Введите id игрока: ");
                int gamerId = scr.nextInt();
                System.out.print("Введите новый класс игрока: ");
                String classificationName = scr.next();
                gamerService.toChangeClassGamer(gamerId, classificationName);
                gamerService.showGamersInfo();
            }
            if(number == 5){
                gameService.turnOff();
                System.out.println("Игра завершена");
            }
        }
    }
}