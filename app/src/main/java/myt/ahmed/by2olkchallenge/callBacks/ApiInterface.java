package myt.ahmed.by2olkchallenge.callBacks;


import myt.ahmed.by2olkchallenge.model.AddressesResponse;
import myt.ahmed.by2olkchallenge.model.api.GoogleApiAutoCompleteResponseModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Ahmed shaban on 8/15/2017.
 */

public interface ApiInterface {

    @GET("places")
    Observable<AddressesResponse> getLocations(@Query("page") int page, @Query("size") int size);

    @GET("places")
    Observable<AddressesResponse> getAutoCompleteLocations(@Query("key") String key, @Query("input") String input);

    @GET
    Observable<GoogleApiAutoCompleteResponseModel>  getAutoCompleteLocations(@Url String url);

}

