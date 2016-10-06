package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.BoardView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager {

    GameFrame othelloFrame;
    BoardView othelloBoard;

    public GameManager(Stage primaryStage) {
       othelloFrame = new GameFrame(primaryStage);
        othelloBoard = new BoardView();
    }

    private void setupGameBoard(){
        othelloFrame.setFrameComponents(othelloBoard.getBoard());
        othelloFrame.InitializeMainFrame();

    }
    
    public void run(){
        
    setupGameBoard();
    
    this.othelloFrame.btExit.setOnAction((ActionEvent e) -> {
    Platform.exit();});
    
    

    }
    
    
    /* Handle a mouse click event */
    private void handleMouseClick() {

    }
  

}