package myt.ahmed.by2olkchallenge.dagger;


import javax.inject.Singleton;

import dagger.Component;
import myt.ahmed.by2olkchallenge.screens.home.MainActivity;
import myt.ahmed.by2olkchallenge.screens.home.HomePresenterImpl;

/**
 * Created by Ahmed shaban on 7/30/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class,PresenterModule.class})
public interface AppComponent {

        void inject(MainActivity mainActivity);
        void inject(HomePresenterImpl  homePresenter);

}
