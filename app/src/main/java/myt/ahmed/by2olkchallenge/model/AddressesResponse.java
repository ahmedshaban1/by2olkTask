package myt.ahmed.by2olkchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ahmed shaban on 9/14/2017.
 */

public class AddressesResponse {

    @SerializedName("content")
    public List<Address> content;
    @SerializedName("last")
    public boolean last;
    @SerializedName("totalPages")
    public int totalPages;
    @SerializedName("totalElements")
    public int totalElements;
    @SerializedName("sort")
    public String sort;
    @SerializedName("first")
    public boolean first;
    @SerializedName("numberOfElements")
    public int numberOfElements;
    @SerializedName("size")
    public int size;
    @SerializedName("number")
    public int number;

    public List<Address> getContent() {
        return content;
    }

    public void setContent(List<Address> content) {
        this.content = content;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
