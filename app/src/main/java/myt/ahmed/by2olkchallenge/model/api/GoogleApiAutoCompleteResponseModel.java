package myt.ahmed.by2olkchallenge.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ahmed shaban on 9/15/2017.
 */

public class GoogleApiAutoCompleteResponseModel {

    @SerializedName("predictions")
    public List<Predictions> predictions;
    @SerializedName("status")
    public String status;

    public static class Matched_substrings {
        @SerializedName("length")
        public int length;
        @SerializedName("offset")
        public int offset;
    }

    public static class Main_text_matched_substrings {
        @SerializedName("length")
        public int length;
        @SerializedName("offset")
        public int offset;
    }

    public static class Structured_formatting {
        @SerializedName("main_text")
        public String main_text;
        @SerializedName("main_text_matched_substrings")
        public List<Main_text_matched_substrings> main_text_matched_substrings;
        @SerializedName("secondary_text")
        public String secondary_text;
    }

    public static class Terms {
        @SerializedName("offset")
        public int offset;
        @SerializedName("value")
        public String value;
    }

    public static class Predictions {
        @SerializedName("description")
        public String description;
        @SerializedName("id")
        public String id;
        @SerializedName("matched_substrings")
        public List<Matched_substrings> matched_substrings;
        @SerializedName("place_id")
        public String place_id;
        @SerializedName("reference")
        public String reference;
        @SerializedName("structured_formatting")
        public Structured_formatting structured_formatting;
        @SerializedName("terms")
        public List<Terms> terms;
    }
}
