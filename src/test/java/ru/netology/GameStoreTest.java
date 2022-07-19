package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test   // добавление 1 игры в каталог
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Нетология Основы Git", "Аркады", store);
        assertFalse(store.containsGame(game) && store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();
        Game game2 = new Game("Нетология Основы Git", "Аркады", store);
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Leonid", 0);
        String actual = store.getMostPlayer();
        String expected = "Leonid";
        assertEquals(expected, actual);
    }

    @Test   // ищет игрока, который проиграл больше всего времени (отсутствующих игроков)
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
    @Test // сумма часов игроков
    public void shouldSumTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Leonid", 1);
        store.addPlayTime("Valentina", 1);
        store.addPlayTime("Philip", 1);
        assertEquals(3, store.getSumPlayedTime());
    }

}
