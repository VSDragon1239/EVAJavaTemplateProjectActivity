package com.agp.template.presentation.views.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agp.template.activity.databinding.FragmentHomeBinding;
import com.agp.template.presentation.viewmodels.mainwindow.fragments.HomeViewModel;


public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;  // Объявляем переменную для DataBinding

    public HomeFragment() { }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);  // Инициализируем DataBinding
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        // Устанавливаем ViewModel для Data Binding
        binding.setViewModel(homeViewModel);
        binding.setLifecycleOwner(this);  // Привязываем жизненный цикл

        return binding.getRoot();  // Возвращаем корневой вид
    }
}