package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Radio;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {


    @Test
    void shouldNotInstallWhenBelowMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0,radio.getCurrentStation());
    }
    @Test
    void shouldInstallWhenMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }
    @Test
    void shouldNotInstallWhenAboveMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationShouldThrowExceptionWhenMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStationShouldTChangeWhenValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }


    @Test
    void prevStationShouldThrowExceptionWhenMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevStationShouldChangeWhenMaxStation() {
        Radio radio = new Radio();
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
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }


    @Test
    void shouldInstallWhenMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldInstallWhenMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void shouldNotInstallWhenAboveMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(11);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldChangeWhenMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldChangeWhenValidVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(9);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeShouldNotChangeWhenMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeShouldNotChangeWhenMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }


    @Test
    void decreaseVolumeShouldChangeWhenMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.decreaseVolume();
        assertEquals(9, radio.getCurrentVolume());
    }


}