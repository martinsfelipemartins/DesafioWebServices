
package br.com.desafiowebservices.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class Variant implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String resourceURI;

    protected Variant(Parcel in) {
        name = in.readString();
        resourceURI = in.readString();
    }

    public static final Creator<Variant> CREATOR = new Creator<Variant>() {
        @Override
        public Variant createFromParcel(Parcel in) {
            return new Variant(in);
        }

        @Override
        public Variant[] newArray(int size) {
            return new Variant[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(resourceURI);
    }
}
