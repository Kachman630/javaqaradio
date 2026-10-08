package ru.netology;

public class Radio {
    private int stationsCount;
    private int currentStation;
    private int currentVolume;

    public Radio() {
        this.stationsCount = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public Radio(int stationsCount) {
        this.stationsCount = stationsCount > 0 ? stationsCount : 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation < stationsCount) {
            this.currentStation = newStation;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}