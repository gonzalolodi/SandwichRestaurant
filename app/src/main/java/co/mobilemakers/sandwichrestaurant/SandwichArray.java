package co.mobilemakers.sandwichrestaurant;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by gonzalo.lodi on 27/01/2015.
 */
public class SandwichArray implements Parcelable {
    ArrayList<Sandwich> mOrders;

    public SandwichArray() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("mOrders", mOrders);
        dest.writeBundle(bundle);
    }
    public static final Parcelable.Creator<SandwichArray> CREATOR =
            new Parcelable.Creator<SandwichArray>(){

                @Override
                public SandwichArray createFromParcel(Parcel source) {
                    SandwichArray ordersArray = new SandwichArray();
                    Bundle ordersBundle = source.readBundle(Sandwich.class.getClassLoader());
                    ordersArray.mOrders = ordersBundle.getParcelableArrayList("mOrders");
                    return ordersArray;
                }

                @Override
                public SandwichArray[] newArray(int size) {
                    return new SandwichArray[size];
                }
            };
}
