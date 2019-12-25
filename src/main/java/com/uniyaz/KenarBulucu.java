package com.uniyaz;

public class KenarBulucu {

    YasamHesaplayaci yasamHesaplayaci;

    public KenarBulucu(YasamHesaplayaci yasamHesaplayaci) {
        this.yasamHesaplayaci = yasamHesaplayaci;
    }

    public void altKenarBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
               yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void sagKenarBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void ustKenarBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void solKenarBul(int outOfValueI, int outOfValueJ, MyButton [][] cellButtons) {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ; j <= outOfValueJ + 1; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ; j <= outOfValueJ + 1; j++) {
                yasamHesaplayaci.yasamHesapla(cellButtons[i][j]);
            }
        }
    }
}
