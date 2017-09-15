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

public class SectionViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.section)
    public TextView name;
    public SectionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
