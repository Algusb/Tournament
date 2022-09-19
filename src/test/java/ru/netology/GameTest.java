package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinPlayer1() {
        Player player1 = new Player(1, "Anton", 100);
        Player player2 = new Player(22, "Bella", 200);
        Player player3 = new Player(333, "Celena", 30);
        Player player4 = new Player(44, "Denis", 200);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int actual = game.round(player1.getName(), player3.getName());
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Player player1 = new Player(1, "Anton", 100);
        Player player2 = new Player(22, "Bella", 200);
        Player player3 = new Player(333, "Celena", 30);
        Player player4 = new Player(44, "Denis", 200);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNobodyWin() {
        Player player1 = new Player(1, "Anton", 100);
        Player player2 = new Player(22, "Bella", 200);
        Player player3 = new Player(333, "Celena", 30);
        Player player4 = new Player(44, "Denis", 200);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int actual = game.round(player2.getName(), player4.getName());
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredPlayer2() {
        Player player1 = new Player(1, "Anton", 100);
        Player player2 = new Player(22, "Bella", 200);
        Player player3 = new Player(333, "Celena", 30);
        Player player4 = new Player(44, "Denis", 200);
        Player player5 = new Player(5, "Elena", 500);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player5.getName());
        });

    }

    @Test
    public void notRegisteredPlayer1() {
        Player player1 = new Player(1, "Anton", 100);
        Player player2 = new Player(22, "Bella", 200);
        Player player3 = new Player(333, "Celena", 30);
        Player player4 = new Player(44, "Denis", 200);
        Player player5 = new Player(5, "Elena", 500);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player5.getName(), player4.getName());
        });

    }

}
