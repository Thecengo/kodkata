package com.uniyaz;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class GridButtonContainer extends GridLayout {
    static int outOfValueI;
    static int outOfValueJ;

    int oluSayaci;
    int diriSayaci;

    public MyButton[][] cellButtons = new MyButton[8][8];

    int length = cellButtons.length;

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

                        if (koseMi(length)) {
                            if (sagUstKosedeMi(length))
                                sagUstKoseBul();
                            else if (solUstKosedeMi())
                                solUstKoseBul();
                            else if (sagAltKosedeMi(length))
                                sagAltKoseBul();
                            else if (solAltKosedeMi(length))
                                solAltKoseBul();
                        } else if (kenarMı(length)) {
                            if (altKenarMi(length))
                                altKenarBul();
                            else if (sagKenarMi(length))
                                sagKenarBul();
                            else if (ustKenarMi())
                                ustKenarBul();
                            else if (solKenarMi())
                                solKenarBul();
                        } else {
                            solTarafBul();
                            ustTarafiBul();
                            sagTarafiBul();
                            altTarafiBul();
                        }

                        if (diriSayaci >= 3) {
                            cellButtons[finalI][finalJ].setStyleName(ValoTheme.BUTTON_FRIENDLY);
                        } else {
                            cellButtons[finalI][finalJ].setStyleName(ValoTheme.BUTTON_DANGER);
                            cellButtons[finalI][finalJ].setData(0);
                            cellButtons[finalI][finalJ].setCaption(cellButtons[finalI][finalJ].getData().toString());
                        }

                        oluSayaci = 0;
                        diriSayaci = 0;
                    }
                });
            }
            System.out.println();
        }
    }


    private void solTarafBul() {
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }

            }
    }

    private void ustTarafiBul() {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }
        }
    }

    private void sagTarafiBul() {
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }

        }
    }

    private void altTarafiBul() {
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }
            }
    }

    private boolean solAltKosedeMi(int length) {
        if (outOfValueI == (length - 1) && outOfValueJ == 0)
            return true;
        else
            return false;
    }

    private boolean solUstKosedeMi() {
        if (outOfValueI == 0 && outOfValueJ == 0)
            return true;
        else
            return false;
    }

    private boolean sagUstKosedeMi(int length) {
        if (outOfValueI == 0 && outOfValueJ == (length - 1))
            return true;
        else
            return false;
    }

    private boolean sagAltKosedeMi(int length) {
        if (outOfValueI == (length - 1) && outOfValueJ == (length - 1))
            return true;
        else
            return false;
    }

    private void solAltKoseBul() {
            for (int i = outOfValueI - 1; i < outOfValueI; i++) {
                for (int j = outOfValueJ; j <= outOfValueJ + 1; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }
            }
            for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
                for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                    yasamHesapla(cellButtons[i][j]);
                }
            }
    }

    private void sagAltKoseBul() {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }

    }

    private void sagUstKoseBul() {
        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    private void solUstKoseBul() {
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ; j <= outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }


    private boolean kenarMı(int length) {
        if (!koseMi(length)) {
            if (altKenarMi(length) || sagKenarMi(length) || ustKenarMi() || solKenarMi()) {
                return true;
            } else return false;
        } else return false;
    }

    private boolean sagKenarMi(int length) {
        return outOfValueJ == (length - 1);
    }

    private boolean altKenarMi(int length) {
        return outOfValueI == (length - 1);
    }

    private boolean ustKenarMi() {
        return outOfValueI == 0;
    }

    private boolean solKenarMi() {
        return outOfValueJ == 0;
    }

    private boolean koseMi(int length) {
        if (solAltKosedeMi(length) || solUstKosedeMi() || sagAltKosedeMi(length) || sagUstKosedeMi(length))
            return true;
        else return false;
    }


    public void altKenarBul() {
        for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI - 1; i <= outOfValueI; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void sagKenarBul() {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    private void yasamHesapla(MyButton myButton) {
        myButton.setCaption(myButton.getData().toString());
        if (myButton.getData().equals(0)) {
            oluSayaci++;
        } else
            diriSayaci++;
    }

    public void ustKenarBul() {
        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ - 1; j < outOfValueJ; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ - 1; j <= outOfValueJ + 1; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }

    public void solKenarBul() {
        for (int i = outOfValueI - 1; i < outOfValueI; i++) {
            for (int j = outOfValueJ; j <= outOfValueJ + 1; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
        for (int i = outOfValueI - 1; i <= outOfValueI + 1; i++) {
            for (int j = outOfValueJ + 1; j < outOfValueJ + 2; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }

        for (int i = outOfValueI + 1; i < outOfValueI + 2; i++) {
            for (int j = outOfValueJ; j <= outOfValueJ + 1; j++) {
                yasamHesapla(cellButtons[i][j]);
            }
        }
    }

}