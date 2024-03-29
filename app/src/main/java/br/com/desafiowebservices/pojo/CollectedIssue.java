
package br.com.desafiowebservices.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
public class CollectedIssue implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String resourceURI;

    protected CollectedIssue(Parcel in) {
        name = in.readString();
        resourceURI = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(resourceURI);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CollectedIssue> CREATOR = new Creator<CollectedIssue>() {
        @Override
        public CollectedIssue createFromParcel(Parcel in) {
            return new CollectedIssue(in);
        }

        @Override
        public CollectedIssue[] newArray(int size) {
            return new CollectedIssue[size];
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

}
