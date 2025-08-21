package src;

public class GameController {
    final private GameModel model;
    final private GameView view;

    public GameController() {
        model = new GameModel();
        view = new GameView();

        model.setNextFlag();
        System.out.println(model.getCurrentFlagPath());
        view.updateScore(model.getScore());
        view.updateFlag(model.getCurrentFlagPath());

        view.submitButton.addActionListener(e -> updateGame());
    }

    private void updateGame() {
        model.incrementRoundCount();

        if (model.isAnswerCorrect(view.getUserInput())) {
            model.incrementScore();
            view.updateScore(model.getScore());
        }

        model.setNextFlag();
        view.updateFlag(model.getCurrentFlagPath());
        view.clearAnswerBox();
    }
}
