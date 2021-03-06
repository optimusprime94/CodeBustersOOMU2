/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import grupp01othello.controller.GameManager;
import grupp01othello.model.players.Player;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author optimusprime (Elvir Dzeko).
 */
public class BoardTile extends Pane {

    private int row, col;

    /* Konstruktor */
    public BoardTile(GameManager gm, int row, int col) {


        /* row och col skickas vid event. */
        this.row = row;
        this.col = col;

        this.setPrefSize(2000, 2000);
        /* Hanterare som ligger i gamemanager */
        this.setOnMouseClicked(event -> {
            gm.handle(event);

        });
    }

    /**
     * Målar upp spelbrickan på brädan efter spelarens markörID.
     *
     * @param markerID
     * @return spelbricka med rätt färg som kan läggas till i GameBoard.
     */
    public Ellipse addPiece(int markerID) {

        Ellipse gamepiece = new Ellipse(this.getWidth() / 2,
                this.getHeight() / 2, this.getWidth() / 2 - 10,
                this.getHeight() / 2 - 10);

        gamepiece.radiusXProperty().bind(
                this.widthProperty().divide(2).subtract(10));
        gamepiece.radiusYProperty().bind(
                this.heightProperty().divide(2).subtract(10));
        gamepiece.centerXProperty().bind(
                this.widthProperty().divide(2));
        gamepiece.centerYProperty().bind(
                this.heightProperty().divide(2));

        InnerShadow is = new InnerShadow();

        /* 1 = Svart Bricka */
        switch (markerID) {
            case 666:
                gamepiece.setFill(Color.TRANSPARENT);
                gamepiece.setStroke(Color.GREEN);
                break;
            case 1:
                gamepiece.setFill(Color.BLACK);
                gamepiece.setStroke(Color.DARKGREY);
                is.setColor(Color.WHITE);
                gamepiece.setEffect(is);
                break;
            /* 2 = vit Bricka */
            case 2:
                gamepiece.setFill(Color.WHITE);
                gamepiece.setStroke(Color.DARKGREY);
                gamepiece.setEffect(is);
                break;
            /* Genomsynlig */
            default:
                gamepiece.setFill(Color.TRANSPARENT);
                gamepiece.setStroke(Color.TRANSPARENT);
                break;
        }
        return gamepiece;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public BoardTile getTile() {
        return this;
    }

}
