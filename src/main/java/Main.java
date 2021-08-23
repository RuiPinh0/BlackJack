import model.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        String path = null;

        if(args.length >= 1 && args[0] != null) path = args[0];

        System.out.println(game.run(path));
        game.printResults();
    }
}
