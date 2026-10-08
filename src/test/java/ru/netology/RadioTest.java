package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void shouldCreateWithDefaultStationsCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
    }

    @Test
    void shouldCreateWithCustomStationsCount() {
        Radio radio = new Radio(5);
        assertEquals(5, radio.getStationsCount());
    }

    @Test
    void shouldGoToNextStationNormally() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(2);

        radio.next();

        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToZeroFromMaxStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStationNormally() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(2);

        radio.prev();

        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToMaxFromZeroStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(3);

        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveLimit() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(2);

        radio.setCurrentStation(5);

        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetNegativeStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(2);

        radio.setCurrentStation(-1);

        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolumeNormally() {
        Radio radio = new Radio();
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolumeNormally() {
        Radio radio = new Radio();
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }

        radio.decreaseVolume();

        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }
}