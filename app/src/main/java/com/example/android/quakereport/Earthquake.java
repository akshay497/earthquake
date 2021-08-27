package com.example.android.quakereport;

public class Earthquake {
   private String mMagnitude;
   private String mLocation;
   private Long mDate;

   public Earthquake(String magnitude,String location,Long date )
   {
       mMagnitude=magnitude;
       mLocation=location;
       mDate=date;
   }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getDate() {
        return mDate;
    }
}
