package com.uniyaz;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class GridButtonContainer extends GridLayout {
    static int outOfValueI;
    static int outOfValueJ;

    public MyButton[][] cellButtons = new MyButton[8][8];
    int length = cellButtons.length;

    YasamHesaplayaci yasamHesaplayaci = new YasamHesaplayaci();
    KenarBulucu kenarBulucu = new KenarBulucu(yasamHesaplayaci);
    KoseBulucu koseBulucu = new KoseBulucu(yasamHesaplayaci);
    OrtaTarafBulucu ortaTarafBulucu = new OrtaTarafBulucu(yasamHesaplayaci);

    KontrolEdici kontrolEdici = new KontrolEdici();

    public GridButtonContainer() {
        super(8, 8);

        buildButtonGrid();
        assignValueButtons();
        testButtonData();
        testButtonClick();

    }

    private void buildButtonGrid() {
        for (int i = 0; i < cellButtons.length; i++) {
            for (int j = 0; j < cellButtons[i].length; j++) {
                cellButtons[i][j] = new MyButton();
                addComponent(cellButtons[i][j]);
            }
        }
    }

    private void assignValueButtons() {
        for (int i = 0; i < cellButtons.length; i++) {
            for (int j = 0; j < cellButtons[i].length; j++) {
                double randomValue = Math.random() * 100;
                if (randomValue < 50) {
                    cellButtons[i][j].setData(1);
                } else {
                    cellButtons[i][j].setData(0);
                }
            }
        }
    }

    private void testButtonData() {
        for (int i = 0; i < cellButtons.length; i++) {
            for (int j = 0; j < cellButtons[i].length; j++) {
                System.out.print(cellButtons[i][j].getData() + " ");
            }
            System.out.println(" ");
        }
    }


    private void testButtonClick() {
        for (int i = 0; i < cellButtons.length; i++) {
            for (int j = 0; j < cellButtons[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                cellButtons[i][j].addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        Notification.show(cellButtons[finalI][finalJ].getData() + " " + finalI + " " + finalJ);

                        outOfValueI = finalI;
                        outOfValueJ = finalJ;

                        if (kontrolEdici.koseMi(length, outOfValueI, outOfValueJ)) {

                            if (kontrolEdici.sagUstKosedeMi(length, outOfValueI, outOfValueJ))
                                koseBulucu.sagUstKoseBul(outOfValueI, outOfValueJ, cellButtons);
                            else if (kontrolEdici.solUstKosedeMi(outOfValueI, outOfValueJ))
                                koseBulucu.solUstKoseBul(outOfValueI, outOfValueJ, cellButtons);
                            else if (kontrolEdici.sagAltKosedeMi(length, outOfValueI, outOfValueJ))
                                koseBulucu.sagAltKoseBul(outOfValueI, outOfValueJ, cellButtons);
                            else if (kontrolEdici.solAltKosedeMi(length, outOfValueI, outOfValueJ))
                                koseBulucu.solAltKoseBul(outOfValueI, outOfValueJ, cellButtons);

                        } else if (kontrolEdici.kenarMı(length, outOfValueI, outOfValueJ)) {

                            if (kontrolEdici.altKenarMi(length, outOfValueI))
                                kenarBulucu.altKenarBul(outOfValueI, outOfValueJ,cellButtons);
                            else if (kontrolEdici.sagKenarMi(length, outOfValueJ))
                                kenarBulucu.sagKenarBul(outOfValueI, outOfValueJ, cellButtons);
                            else if (kontrolEdici.ustKenarMi(outOfValueI))
                                kenarBulucu.ustKenarBul(outOfValueI, outOfValueJ, cellButtons);
                            else if (kontrolEdici.solKenarMi(outOfValueJ))
                                kenarBulucu.solKenarBul(outOfValueI, outOfValueJ, cellButtons);

                        } else {
                            ortaTarafBulucu.solTarafBul(outOfValueI, outOfValueJ, cellButtons);
                            ortaTarafBulucu.ustTarafiBul(outOfValueI, outOfValueJ, cellButtons);
                            ortaTarafBulucu.sagTarafiBul(outOfValueI, outOfValueJ, cellButtons);
                            ortaTarafBulucu.altTarafiBul(outOfValueI, outOfValueJ, cellButtons);
                        }

                        if (yasamHesaplayaci.getDiriSayaci() >= 3) {
                            cellButtons[finalI][finalJ].setStyleName(ValoTheme.BUTTON_FRIENDLY);
                        } else {
                            cellButtons[finalI][finalJ].setStyleName(ValoTheme.BUTTON_DANGER);
                            cellButtons[finalI][finalJ].setData(0);
                            cellButtons[finalI][finalJ].setCaption(cellButtons[finalI][finalJ].getData().toString());
                        }

                        yasamHesaplayaci.setDiriSayaci(0);
                        yasamHesaplayaci.setOluSayaci(0);
                    }
                });
            }
            System.out.println();
        }
    }



}