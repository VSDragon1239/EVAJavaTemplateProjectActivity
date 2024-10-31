package com.agp.template.presentation.viewmodels.mainwindow;

import androidx.lifecycle.ViewModel;

import com.agp.template.presentation.viewmodels.mainwindow.fragments.HomeViewModel;
import com.agp.template.presentation.viewmodels.mainwindow.fragments.SettingsViewModel;

public class MainSharedViewModel extends ViewModel {
    private HomeViewModel homeViewModel;
    private SettingsViewModel settingsViewModel;

    public void setHomeViewModel(HomeViewModel homeViewModel) {
        this.homeViewModel = homeViewModel;
    }

    public void setSettingsViewModel(SettingsViewModel settingsViewModel) {
        this.settingsViewModel = settingsViewModel;
    }

    // Пример метода, вызывающего функционал в HomeViewModel
    public void updateHomeFragmentData(String newData) {
        if (homeViewModel != null) {
            homeViewModel.updateData(newData);
        }
    }

    // Пример метода, вызывающего функционал в SettingViewModel
    public void updateSettingsFragmentData(String settingsData) {
        if (settingsViewModel != null) {
            settingsViewModel.applySettings(settingsData);
        }
    }
}
