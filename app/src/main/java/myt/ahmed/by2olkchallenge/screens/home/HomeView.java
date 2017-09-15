package myt.ahmed.by2olkchallenge.screens.home;

import java.util.ArrayList;
import java.util.List;

import myt.ahmed.by2olkchallenge.model.Address;


/**
 * Created by Ahmed shaban on 8/15/2017.
 */


public interface HomeView {
    void showLoader();
    void hideLoader();
    void RequestList(List<Address> addresses);
    void showWaring(String string);

    void updateAutoComplete(List<Address> addressList);
}
