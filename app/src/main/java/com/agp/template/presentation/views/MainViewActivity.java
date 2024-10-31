package com.agp.template.presentation.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.agp.template.activity.R;
import com.agp.template.activity.databinding.ActivityMainBinding;
import com.agp.template.presentation.viewmodels.mainwindow.MainSharedViewModel;
import com.agp.template.presentation.viewmodels.mainwindow.MainViewModelActivity;
import com.agp.template.activity.databinding.NavigationMenuBinding;
import com.agp.template.presentation.viewmodels.mainwindow.fragments.HomeViewModel;
import com.agp.template.presentation.viewmodels.mainwindow.fragments.SettingsViewModel;
import com.agp.template.presentation.views.fragments.HomeFragment;
import com.agp.template.presentation.views.fragments.SettingsFragment;
import com.agp.template.utils.Logger;

public class MainViewActivity extends AppCompatActivity {  // исправлено имя класса
    private static final String TAG = "MainViewActivity";
    private MainViewModelActivity viewModel; // Объявляем переменную для ViewModel
    private MainSharedViewModel sharedViewModel;
    private HomeViewModel homeViewModel;
    private SettingsViewModel settingsViewModel;

    private ActivityMainBinding ViewBinding;  // ViewBinding для основного макета
    private NavigationMenuBinding navigationBinding;  // ViewBinding для включенного макета

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.log(TAG, "onCreate");


        // ===  Инициализация ViewBinding для activity_main  ===
        ViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ViewBinding.getRoot());



        // Инициализация ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModelActivity.class);
        sharedViewModel = new ViewModelProvider(this).get(MainSharedViewModel.class);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        // Связываем homeViewModel и settingViewModel с sharedViewModel
        sharedViewModel.setHomeViewModel(homeViewModel);
        sharedViewModel.setSettingsViewModel(settingsViewModel);

        // Устанавливаем sharedViewModel в mainViewModel
        viewModel.setSharedViewModel(sharedViewModel);




        // Установка ViewModel и привязка к жизненному циклу для Data Binding
        ViewBinding.setViewModel(viewModel);
        ViewBinding.setLifecycleOwner(this);



        // Настройка WindowInsets для Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(ViewBinding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация View Binding для навигационного меню
        navigationBinding = NavigationMenuBinding.bind(ViewBinding.navigationMenu.getRoot());

        // Устанавливаем фрагмент по умолчанию (например, HomeFragment)
        replaceFragment(new HomeFragment());

        // Установка слушателей для элементов навигационного меню
        navigationBinding.homeButton.setOnClickListener(v -> replaceFragment(new HomeFragment()));
        navigationBinding.settingsButton.setOnClickListener(v -> replaceFragment(new SettingsFragment()));
    }


    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.log(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.log(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.log(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.log(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.log(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.log(TAG, "onDestroy");
    }
}
