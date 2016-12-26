package com.example.dadabhagwan.mytask.ListviewTask2.UserModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dadabhagwan on 10/18/2016.
 */

public class UserModel implements Parcelable {
public String FirstName;
public String LastName;

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
    }

    public UserModel() {
    }

    protected UserModel(Parcel in) {
        this.FirstName = in.readString();
        this.LastName = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
