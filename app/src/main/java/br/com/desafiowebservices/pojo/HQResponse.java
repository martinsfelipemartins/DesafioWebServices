
package br.com.desafiowebservices.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class HQResponse implements Parcelable {

    @Expose
    private String attributionHTML;
    @Expose
    private String attributionText;
    @Expose
    private String code;
    @Expose
    private String copyright;
    @Expose
    private Data data;
    @Expose
    private String etag;
    @Expose
    private String status;

    protected HQResponse(Parcel in) {
        attributionHTML = in.readString();
        attributionText = in.readString();
        code = in.readString();
        copyright = in.readString();
        etag = in.readString();
        status = in.readString();
    }

    public static final Creator<HQResponse> CREATOR = new Creator<HQResponse>() {
        @Override
        public HQResponse createFromParcel(Parcel in) {
            return new HQResponse(in);
        }

        @Override
        public HQResponse[] newArray(int size) {
            return new HQResponse[size];
        }
    };

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(attributionHTML);
        dest.writeString(attributionText);
        dest.writeString(code);
        dest.writeString(copyright);
        dest.writeString(etag);
        dest.writeString(status);
    }
}
