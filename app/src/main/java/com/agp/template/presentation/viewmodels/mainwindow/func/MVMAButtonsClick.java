package com.agp.template.presentation.viewmodels.mainwindow.func;

public class MVMAButtonsClick {
    // Логика обработки нажатия кнопки
    String data = "";
    String BCBTN = "";
    public void click(String BTN) {
        BCBTN = BTN;
        setText();
    }

    public String getResult() {
        return data;
    }

    private void setText() {
        if (BCBTN.equals("1")) {
            data = "Текст сверху в TextView - 1 кнопка активировала";
        } else if (BCBTN.equals("2")) {
            data = "Текст сверху в TextView - 2 кнопка активировала";
        }
    }
}
