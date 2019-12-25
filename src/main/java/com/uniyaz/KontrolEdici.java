package com.uniyaz;

public class KontrolEdici {

    public boolean sagKenarMi(int length, int outOfValueJ) {
        return outOfValueJ == (length - 1);
    }

    public boolean altKenarMi(int length, int outOfValueI) {
        return outOfValueI == (length - 1);
    }

    public boolean ustKenarMi(int outOfValueI) {
        return outOfValueI == 0;
    }

    public boolean solKenarMi(int outOfValueJ) {
        return outOfValueJ == 0;
    }

    public boolean koseMi(int length, int outOfValueI, int outOfValueJ) {
        if (solAltKosedeMi(length, outOfValueI, outOfValueJ)
                || solUstKosedeMi(outOfValueI, outOfValueJ)
                || sagAltKosedeMi(length, outOfValueI, outOfValueJ)
                || sagUstKosedeMi(length, outOfValueI, outOfValueJ))
            return true;
        else return false;
    }

    public boolean solAltKosedeMi(int length, int outOfValueI, int outOfValueJ) {
        if (outOfValueI == (length - 1) && outOfValueJ == 0)
            return true;
        else
            return false;
    }

    public boolean solUstKosedeMi(int outOfValueI, int outOfValueJ) {
        if (outOfValueI == 0 && outOfValueJ == 0)
            return true;
        else
            return false;
    }

    public boolean sagUstKosedeMi(int length, int outOfValueI, int outOfValueJ) {
        if (outOfValueI == 0 && outOfValueJ == (length - 1))
            return true;
        else
            return false;
    }

    public boolean sagAltKosedeMi(int length, int outOfValueI, int outOfValueJ) {
        if (outOfValueI == (length - 1) && outOfValueJ == (length - 1))
            return true;
        else
            return false;
    }


    public boolean kenarMı(int length, int outOfValueI, int outOfValueJ) {
        if (!koseMi(length, outOfValueI, outOfValueJ)) {
            if (altKenarMi(length, outOfValueI)
                    || sagKenarMi(length, outOfValueJ)
                    || ustKenarMi(outOfValueI)
                    || solKenarMi(outOfValueJ)) {
                return true;
            } else return false;
        } else return false;
    }

}
