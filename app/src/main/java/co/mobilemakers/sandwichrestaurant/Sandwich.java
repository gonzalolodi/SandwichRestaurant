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

    public Sandwich(){

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

    }
}
