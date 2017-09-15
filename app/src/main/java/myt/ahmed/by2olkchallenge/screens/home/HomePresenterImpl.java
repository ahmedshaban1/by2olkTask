package myt.ahmed.by2olkchallenge.screens.home;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import myt.ahmed.by2olkchallenge.Helpers.ServicesConnection;
import myt.ahmed.by2olkchallenge.callBacks.ApiInterface;
import myt.ahmed.by2olkchallenge.dagger.DaggerApplication;
import myt.ahmed.by2olkchallenge.model.Address;
import myt.ahmed.by2olkchallenge.model.AddressesResponse;
import myt.ahmed.by2olkchallenge.model.api.GoogleApiAutoCompleteResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ahmed shaban on 8/15/2017.
 */
public class HomePresenterImpl implements HomePresenter {
    HomeView view;
    @Inject
    ApiInterface apiInterface;
    @Inject
    Context context;
    int page = 0;
    int size = 25;
    boolean last = false;
    Subscription subscription;



    @Override
    public void setView(HomeView view) {
        this.view = view;
    }

    public HomePresenterImpl(Context context) {
        ((DaggerApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void setRequestList() {
        subscription = apiInterface.getLocations(page,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddressesResponse>() {
                    @Override
                    public final void onCompleted() {
                    }

                    @Override
                    public final void onError(Throwable e) {
                    }

                    @Override
                    public final void onNext(AddressesResponse response) {
                       view.RequestList(response.content);
                    }
                });
    }


    @Override
    public void setAutoCompleteList(String input) {
        String custom_url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?key="+ServicesConnection.key+"&input="+input;
        subscription = apiInterface.getAutoCompleteLocations(custom_url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoogleApiAutoCompleteResponseModel>() {
                    @Override
                    public final void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public final void onError(Throwable e) {
                        Log.e("GithubDemo", e.getMessage());
                    }

                    @Override
                    public final void onNext(GoogleApiAutoCompleteResponseModel response) {
                        List<Address> addressList = new ArrayList<>();
                        if(response.predictions.size() > 0){

                            for(int i = 0 ; i < response.predictions.size();i++){
                                Address address  = new Address();
                                address.setAddress(response.predictions.get(i).description);
                                address.setName(response.predictions.get(i).structured_formatting.main_text);
                                addressList.add(address);

                            }

                        }

                        view.updateAutoComplete(addressList);

                    }
                });
    }



}
