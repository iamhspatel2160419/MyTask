package com.example.dadabhagwan.mytask.plainOldJavaObject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dadabhagwan on 10/17/2016.
 */

public class Model implements Parcelable {
    public Integer RollNo;
    public String FirtsName;
    public String LastName;
    public String City;
    public String Gender;


    public Integer getRollNo() {
        return RollNo;
    }

    public void setRollNo(Integer rollNo) {
        RollNo = rollNo;
    }

    public String getFirtsName() {
        return FirtsName;
    }

    public void setFirtsName(String firtsName) {
        FirtsName = firtsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.RollNo);
        dest.writeString(this.FirtsName);
        dest.writeString(this.LastName);
        dest.writeString(this.City);
        dest.writeString(this.Gender);
    }

    public Model() {
    }

    protected Model(Parcel in) {
        this.RollNo = (Integer) in.readValue(Integer.class.getClassLoader());
        this.FirtsName = in.readString();
        this.LastName = in.readString();
        this.City = in.readString();
        this.Gender = in.readString();
    }

    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
