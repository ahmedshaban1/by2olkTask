package myt.ahmed.by2olkchallenge.screens.home;

import android.content.Context;

import javax.inject.Inject;


import myt.ahmed.by2olkchallenge.callBacks.ApiInterface;
import myt.ahmed.by2olkchallenge.dagger.DaggerApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed shaban on 8/15/2017.
 */
public class HomePresenterImpl implements HomePresenter {
    HomeView view;
    @Inject
    ApiInterface apiInterface;
    @Inject
    Context context;

    @Override
    public void setView(HomeView view) {
        this.view = view;
    }

    public HomePresenterImpl(Context context) {
        ((DaggerApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void setRequestList() {

     }
}
