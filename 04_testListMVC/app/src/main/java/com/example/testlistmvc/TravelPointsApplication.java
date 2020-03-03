package com.example.testlistmvc;

import android.app.Application;
import com.example.testlistmvc.Modelos.InterestPoint;
import java.util.ArrayList;
import java.util.List;

public class TravelPointsApplication extends Application {

    public List<InterestPoint> pointList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
