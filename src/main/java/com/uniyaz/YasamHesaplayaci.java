package com.uniyaz;

public class YasamHesaplayaci {

    private int oluSayaci;
    private int diriSayaci;

    public void yasamHesapla(MyButton myButton) {
        myButton.setCaption(myButton.getData().toString());
        if (myButton.getData().equals(0)) {
            oluSayaci++;
        } else
            diriSayaci++;
    }

    public int getOluSayaci() {
        return oluSayaci;
    }

    public void setOluSayaci(int oluSayaci) {
        this.oluSayaci = oluSayaci;
    }

    public int getDiriSayaci() {
        return diriSayaci;
    }

    public void setDiriSayaci(int diriSayaci) {
        this.diriSayaci = diriSayaci;
    }
}
