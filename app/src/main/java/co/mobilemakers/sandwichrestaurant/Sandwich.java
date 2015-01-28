package co.mobilemakers.sandwichrestaurant;

import android.os.Parcel;
import android.os.Parcelable;
import android.print.PageRange;

/**
 * Created by gonzalo.lodi on 27/01/2015.
 */
public class Sandwich implements Parcelable{
    String bread;
    String toppingOptions;

    public Sandwich(String toppingOptions, String bread) {
        this.toppingOptions = toppingOptions;
        this.bread = bread;
    }

    public String getToppingOptions() {
        return toppingOptions;
    }

    public void setToppingOptions(String toppingOptions) {
        this.toppingOptions = toppingOptions;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bread);
        dest.writeString(toppingOptions);
    }

    public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>(){

        @Override
        public Sandwich createFromParcel(Parcel source) {
            return new Sandwich(source);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };

    private Sandwich (Parcel source){
        bread = source.readString();
        toppingOptions= source.readString();
    }
}
