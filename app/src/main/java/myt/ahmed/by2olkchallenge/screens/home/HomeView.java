package myt.ahmed.by2olkchallenge.screens.home;

import java.util.ArrayList;


/**
 * Created by Ahmed shaban on 8/15/2017.
 */


public interface HomeView {
    void showLoader();
    void hideLoader();
    void RequestList(ArrayList<Integer> cities);
    void showWaring(String string);
}
