package myt.ahmed.by2olkchallenge.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import myt.ahmed.by2olkchallenge.screens.home.HomePresenter;
import myt.ahmed.by2olkchallenge.screens.home.HomePresenterImpl;

/**
 * Created by Ahmed shaban on 7/30/2017.
 */

@Module
public class PresenterModule {


    @Provides
    @Singleton
    HomePresenter provideTestPresenterImpl(Context context) {
        return new HomePresenterImpl(context);
    }



}

