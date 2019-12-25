package com.uniyaz;

public class OrtaTarafBulucu {
    YasamHesaplayaci yasamHesaplayaci;

    public OrtaTarafBulucu(YasamHesaplayaci yasamHesaplayaci) {
        this.yasamHesaplayaci = yasamHesaplayaci;
    }

    public void solTarafBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }

        }
    }

    public void ustTarafiBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void sagTarafiBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }

        }
    }

    public void altTarafiBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }


}
