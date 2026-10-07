package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void shouldGoToNextStationFromMiddle() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldGoToZeroFromMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStationFromMiddle() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldGoToMaxFromZeroStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);

        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationAboveLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(10);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationBelowLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(-1);

        assertEquals(5, radio.getCurrentStation());
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
