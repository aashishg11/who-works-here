package com.aashishgodambe.whosworking.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.aashishgodambe.whosworking.views.EmployeeListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(EmployeeListViewModel.class)
    abstract ViewModel provideEmployeeListViewModel(EmployeeListViewModel restaurantListViewModel);

}
