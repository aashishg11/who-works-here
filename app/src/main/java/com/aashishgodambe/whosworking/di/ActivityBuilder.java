package com.aashishgodambe.whosworking.di;

import com.aashishgodambe.whosworking.views.EmployeeListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = FragmentBuilder.class)
    abstract EmployeeListActivity bindEmployeeListActivity();

}

