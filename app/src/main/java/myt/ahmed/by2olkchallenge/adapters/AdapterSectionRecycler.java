package myt.ahmed.by2olkchallenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intrusoft.sectionedrecyclerview.Section;
import com.intrusoft.sectionedrecyclerview.SectionRecyclerViewAdapter;

import java.util.List;

import myt.ahmed.by2olkchallenge.Helpers.AddressViewHolder;
import myt.ahmed.by2olkchallenge.Helpers.SectionHeader;
import myt.ahmed.by2olkchallenge.Helpers.SectionViewHolder;
import myt.ahmed.by2olkchallenge.R;
import myt.ahmed.by2olkchallenge.model.Address;

/**
 * Created by Ahmed shaban on 9/15/2017.
 */

public class AdapterSectionRecycler extends SectionRecyclerViewAdapter<SectionHeader, Address, SectionViewHolder, AddressViewHolder> {

    Context context;

    public AdapterSectionRecycler(Context context, List<SectionHeader> sectionItemList) {
        super(context, sectionItemList);
        this.context = context;
    }

    @Override
    public SectionViewHolder onCreateSectionViewHolder(ViewGroup sectionViewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_header, sectionViewGroup, false);
        return new SectionViewHolder(view);
    }

    @Override
    public AddressViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.address_item, childViewGroup, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindSectionViewHolder(SectionViewHolder sectionViewHolder, int sectionPosition, SectionHeader section) {
        sectionViewHolder.name.setText(section.sectionText);
    }

    @Override
    public void onBindChildViewHolder(AddressViewHolder addressViewHolder, int sectionPosition, int childPosition, Address address) {
        addressViewHolder.name.setText(address.getName());
        addressViewHolder.description.setText(address.getAddress());
    }
}
