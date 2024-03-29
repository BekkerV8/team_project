package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test   // добавление одной игры в каталог
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Основы Git", "Аркады");
        assertTrue(store.containsGame(game2));
    }
    @Test
    public void shouldAddFalseGames() {

        GameStore store = new GameStore();
        Game game3 = new Game("Нетология Введение В Java", "Приключения", store);
        assertFalse(store.containsGame(game3));
    }

    @Test
    public void shouldGetMostPlayerEquals() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Leonid", 3);
        store.addPlayTime("Valentina", 1);
        store.addPlayTime("Philip", 3);
        String actual = store.getMostPlayer();
        String expected = "Leonid";
        assertEquals(expected, actual);
    }

    @Test   // ищет игрока, который играл больше всего времени
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();
        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Leonid", -1);
        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test    // сумма часов с 0 игроков
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();
        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test // сумма часов всех игроков
    public void shouldSumTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Leonid", 1);
        store.addPlayTime("Valentina", 1);
        store.addPlayTime("Philip", 1);
        assertEquals(3, store.getSumPlayedTime());
    }
    @Test // время, которое проиграл игрок за игрой этого каталога.
    public void shouldAddPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Leonid", 1);
        store.addPlayTime("Leonid", 1);
        assertEquals(2, store.getSumPlayedTime());
    }

}
