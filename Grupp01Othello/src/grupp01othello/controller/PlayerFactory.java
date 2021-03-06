/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import grupp01othello.model.OthelloGrid;
import grupp01othello.model.players.*;
import grupp01othello.view.GameBoard;
import grupp01othello.view.dialog.PlayerExists;
import grupp01othello.view.dialog.SetUpGameDialog;
import java.io.IOException;

/**
 *
 * @author Markus, Elvir
 */
public class PlayerFactory {

    private Player player1, player2;
    private String playerName, playerType, playerName2, playerType2;
    private OthelloGrid grid;
    private GameBoard board;

    /**
     * Konstruktor. PlayerFactory skapar Dialoger till användaren för att skapa
     * spelare, bestämma namn och typ av spelare
     *
     * @param grid
     * @param board
     */
    PlayerFactory(OthelloGrid grid, GameBoard board) {
        try {
            PlayerExists existsDialog;
            SetUpGameDialog dialog;
            dialog = new SetUpGameDialog();
            this.grid = grid;
            this.board = board;

            playerName = dialog.InfoBoxName();
            System.out.println("" + playerName);
            playerType = dialog.InfoBoxTypePlayer();
            playerName2 = dialog.InfoBoxName();
            System.out.println("" + playerName2);
            playerType2 = dialog.InfoBoxTypePlayer();

            if (playerName.equals(playerName2)) {
                existsDialog = new PlayerExists();
                existsDialog.PlayerExistsAlert();
                playerName2 = dialog.InfoBoxName();
                if (playerName2.equals(playerName)) {
                    existsDialog.PlayerExistsAlert();
                    playerName2 = dialog.InfoBoxName();
                }

            }
            if (playerType.equals("Human")) {
                player1 = new HumanPlayer(1, playerName, grid, board);
            } else if (playerType.equals("LocalComputerPlayer")) {
                player1 = new LocalComputerPlayer(1, playerName, grid);
            } else if (playerType.equals("RemoteComputerPlayer")) {
                player1 = new RemoteComputerPlayer(1, playerName, grid);
            }
            if (playerType2.equals("Human")) {
                player2 = new HumanPlayer(2, playerName2, grid, board);
            } else if (playerType2.equals("LocalComputerPlayer")) {
                player2 = new LocalComputerPlayer(2, playerName2, grid);
            } else if (playerType2.equals("RemoteComputerPlayer")) {
                player2 = new RemoteComputerPlayer(2, playerName2, grid);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Un-able to connect!");
        }

    }

    /* Getter för player 1 */
    public Player getPlayerOne() {
        return player1;
    }

    /* Getter för player 2 */
    public Player getPlayerTwo() {
        return player2;
    }

}
