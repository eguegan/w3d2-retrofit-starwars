
package com.example.test.samplemasterdetail.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon implements Parcelable {

    @SerializedName("URL")
    @Expose
    private String URL;
    @SerializedName("Height")
    @Expose
    private String Height;
    @SerializedName("Width")
    @Expose
    private String Width;

    /**
     *
     * @return
     *     The URL
     */
    public String getURL() {
        return URL;
    }

    /**
     *
     * @param URL
     *     The URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     *
     * @return
     *     The Height
     */
    public String getHeight() {
        return Height;
    }

    /**
     *
     * @param Height
     *     The Height
     */
    public void setHeight(String Height) {
        this.Height = Height;
    }

    /**
     *
     * @return
     *     The Width
     */
    public String getWidth() {
        return Width;
    }

    /**
     *
     * @param Width
     *     The Width
     */
    public void setWidth(String Width) {
        this.Width = Width;
    }


    protected Icon(Parcel in) {
        URL = in.readString();
        Height = in.readString();
        Width = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(URL);
        dest.writeString(Height);
        dest.writeString(Width);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() {
        @Override
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        @Override
        public Icon[] newArray(int size) {
            return new Icon[size];
        }
    };
}