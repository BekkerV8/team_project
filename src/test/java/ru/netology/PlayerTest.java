package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты

    //Поверяем игру заданного жанра, в которую больше всего играли. Метод не создан.
    @Test
    public void mostPlayerByGenreTest() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Основы Git", "Аркады");
        Game game3 = store.publishGame("Нетология Java для тестировщиков", "Хоррор");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1,3);
        player.play(game2,4);
        player.play(game3,5);
        player.play(game1,3);

        String searchGenre = "Аркады";

        Game expected = game1;
        Game actual = player.mostPlayerByGenre(searchGenre);
        assertEquals (expected, actual);
    }

    //Проверяем, сохраняются ли данные после установки уже установленной ранее игры - одинаковый ключ name
    //Можно проверить после доработки play
    @Test
    public void installGameIsAlreadyInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);
        player.play(game, 4);

        int expected = 7;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

}
