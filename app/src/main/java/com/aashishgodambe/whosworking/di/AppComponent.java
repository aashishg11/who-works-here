package com.aashishgodambe.whosworking.di;

import com.aashishgodambe.whosworking.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        ViewModelModule.class,
        ApiServiceModule.class,
        NetworkModule.class,
})

public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication application);
        Builder appModule(AppModule appModule);
        AppComponent build();
    }

    void inject(BaseApplication application);

}
