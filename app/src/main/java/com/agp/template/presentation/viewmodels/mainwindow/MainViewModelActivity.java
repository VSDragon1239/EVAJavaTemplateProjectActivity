package com.agp.template.presentation.viewmodels.mainwindow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agp.template.data.repository.DataRepository;
import com.agp.template.presentation.viewmodels.mainwindow.func.MVMAButtonsClick;
import com.agp.template.utils.Logger;

public class MainViewModelActivity extends ViewModel {
    String lastActBtnId = "";
    String TAG = "MainViewModelActivity";

    private MainSharedViewModel sharedViewModel;  // Поле для SharedViewModel

    private final MutableLiveData<String> text = new MutableLiveData<>("Изначальный текст при запуске.com");
    private final MutableLiveData<String> btnText1 = new MutableLiveData<>("Название Кнопки 1");
    private final MutableLiveData<String> btnText2 = new MutableLiveData<>("Название Кнопки 2");
    private final MutableLiveData<String> btnText3 = new MutableLiveData<>("Загрузить данные");
    private final MutableLiveData<String> btnText4 = new MutableLiveData<>("Тестирование");
    private final DataRepository repository;
    private final MVMAButtonsClick buttons_click;

    public void setSharedViewModel(MainSharedViewModel mainSharedViewModel) {
        this.sharedViewModel = mainSharedViewModel;
    }

    public MainViewModelActivity() {
        buttons_click = new MVMAButtonsClick();
        repository = new DataRepository();
        Logger.log(TAG, "== 'MainViewModelActivity' active! ==");

    }

    // Возвращает данные для наблюдения в View
    public LiveData<String> getText() {
        String lastText = "1";
        TAG = "getBtnText" + lastText;
        Logger.log(TAG, "== 'getBtnText1' active! ==" + btnText1);

        return text;
    }

    public LiveData<String> getBtnText1() {
        String lastText = "2";
        TAG = "getBtnText" + lastText;
        Logger.log(TAG, "== 'getBtnText1' active! ==" + btnText1);

        return btnText1;
    }

    public LiveData<String> getBtnText2() {
        String lastText = "3";
        TAG = "getBtnText" + lastText;
        Logger.log(TAG, "== 'getBtnText2' active! ==");

        return btnText2;
    }

    public LiveData<String> getBtnText3() {
        String lastText = "3";
        TAG = "getBtnText" + lastText;
        Logger.log(TAG, "== 'getBtnText3' active! ==");

        return btnText3;
    }

    public LiveData<String> getBtnText4() {
        String lastText = "4";
        TAG = "getBtnText" + lastText;
        Logger.log(TAG, "== 'getBtnText4' active! ==");

        return btnText4;
    }

    // Метод для обновления текста при клике на кнопку
    public void onButtonClick1() {
        lastActBtnId = "1";
        TAG = "OnButtonClick" + lastActBtnId;
        Logger.log(TAG, "== 'Button 1' clicked! ==");
        buttons_click.click("1");
        String oBS = buttons_click.getResult();
        text.setValue(oBS);
        sharedViewModel.updateHomeFragmentData("Новые данные для HomeFragment");
    }

    public void onButtonClick2() {
        lastActBtnId = "2";
        TAG = "OnButtonClick" + lastActBtnId;
        Logger.log("OnButtonClick2", "== 'Button 2' clicked! ==");
        buttons_click.click("2");
        String oBS = buttons_click.getResult();
        text.setValue(oBS);
    }

    // Асинхронный метод для загрузки данных
    public void loadData() {
        lastActBtnId = "3";
        TAG = "OnButtonClick" + lastActBtnId;
        Logger.log(TAG, "== 'Button 2' clicked! ==");

        new Thread(() -> {
            String result = repository.loadData();
            text.postValue(result);
        }).start();
        btnText3.setValue("Данные загружены");
    }
}
