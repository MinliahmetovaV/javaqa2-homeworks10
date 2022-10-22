package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Radio;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    void shouldNotInstallWhenBelowMinStation() {
        radio.setCurrentStation(-1);
        assertEquals(0,radio.getCurrentStation());
    }
    @Test
    void shouldInstallWhenMaxStation() {
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }
    @Test
    void shouldNotInstallWhenAboveMaxStation() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationShouldThrowExceptionWhenMaxStation() {
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationShouldTChangeWhenValidStation() {
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationShouldThrowExceptionWhenMinStation() {
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationShouldChangeWhenMaxStation() {
        radio.setCurrentStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    void shouldInstallStationBySpecifyingNumber() {
        Radio radio = new Radio(9);
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldNotInstallWhenBelowMinVolume() {
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldInstallWhenMinVolume() {
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldInstallWhenMaxVolume() {
        radio.setCurrentVolume(10);
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void shouldNotInstallWhenAboveMaxVolume() {
        radio.setCurrentVolume(11);
        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void shouldInstallIfAverageVolume() {
        radio.setCurrentVolume(5);
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldChangeWhenMinVolume() {
        radio.setCurrentVolume(0);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldChangeWhenValidVolume() {
        radio.setCurrentVolume(9);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldNotChangeWhenMaxVolume() {
        radio.setCurrentVolume(10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeShouldNotChangeWhenMinVolume() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }


    @Test
    void decreaseVolumeShouldChangeWhenMaxVolume() {
        radio.setCurrentVolume(10);
        radio.decreaseVolume();
        assertEquals(9, radio.getCurrentVolume());
    }

}