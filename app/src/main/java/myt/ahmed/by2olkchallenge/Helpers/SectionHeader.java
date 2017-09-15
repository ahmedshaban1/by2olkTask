package myt.ahmed.by2olkchallenge.Helpers;

import com.intrusoft.sectionedrecyclerview.Section;

import java.util.List;

import myt.ahmed.by2olkchallenge.model.Address;

/**
 * Created by Ahmed shaban on 9/15/2017.
 */
public class SectionHeader implements Section<Address>{

    List<Address> childList;
    public String sectionText;

    public SectionHeader(List<Address> childList, String sectionText) {
        this.childList = childList;
        this.sectionText = sectionText;
    }

    @Override
    public List<Address> getChildItems() {
        return childList;
    }

    public String getSectionText() {
        return sectionText;
    }

    public void setChildList(List<Address> childList) {
        this.childList = childList;
    }
}