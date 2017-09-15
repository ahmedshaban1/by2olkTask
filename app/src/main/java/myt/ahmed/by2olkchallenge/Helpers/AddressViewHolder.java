package myt.ahmed.by2olkchallenge.Helpers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import myt.ahmed.by2olkchallenge.R;

/**
 * Created by Ahmed shaban on 9/15/2017.
 */

public class AddressViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.title)
    public TextView name;
    @Bind(R.id.description)
    public TextView description;
    public AddressViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
