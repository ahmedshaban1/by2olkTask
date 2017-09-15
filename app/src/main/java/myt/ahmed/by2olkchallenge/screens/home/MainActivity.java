package myt.ahmed.by2olkchallenge.screens.home;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.intrusoft.sectionedrecyclerview.Section;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import myt.ahmed.by2olkchallenge.Helpers.SectionHeader;
import myt.ahmed.by2olkchallenge.R;
import myt.ahmed.by2olkchallenge.adapters.AdapterSectionRecycler;
import myt.ahmed.by2olkchallenge.dagger.DaggerApplication;
import myt.ahmed.by2olkchallenge.model.Address;

public class MainActivity extends AppCompatActivity implements HomeView {
    @Bind(R.id.list)
    RecyclerView listAddresses;
    List<Address> addressApiList;
    List<Address> addressApiListGoogle;
    AdapterSectionRecycler adapterRecycler;
    @Inject
    HomePresenter presenter;
    List<SectionHeader> sections;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((DaggerApplication)getApplication()).getAppComponent().inject(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listAddresses.setLayoutManager(linearLayoutManager);
        listAddresses.setHasFixedSize(true);
        addressApiList = new ArrayList<>();
        addressApiListGoogle = new ArrayList<>();
        presenter.setView(this);
        sections = new ArrayList<>();
        sections.add(new SectionHeader(addressApiListGoogle, "Addresses from Google"));
        sections.add(new SectionHeader(addressApiList,"Addresses From Api"));
        adapterRecycler = new AdapterSectionRecycler(this, sections);
        listAddresses.setAdapter(adapterRecycler);
        presenter.setRequestList();
        presenter.setAutoCompleteList("ri");


    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void RequestList(List<Address> addresses) {
        addressApiList.addAll(addresses);
        adapterRecycler.notifyDataChanged(sections);

    }

    @Override
    public void showWaring(String string) {

    }

    @Override
    public void updateAutoComplete(List<Address> addressList) {
        addressApiListGoogle.addAll(addressList);
        adapterRecycler.notifyDataChanged(sections);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        }

        final SearchView finalSearchView = searchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Search(query);
                if( ! finalSearchView.isIconified()) {
                    finalSearchView.setIconified(true);
                }
                searchItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                Search(s);
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(ListData.this, "Closed", Toast.LENGTH_SHORT).show();
                ResetList();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
