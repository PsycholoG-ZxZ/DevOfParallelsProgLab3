package AirportsAndDelaysPack;

import org.apache.spark.api.java.JavaPairRDD;

import java.io.Serializable;

public class FlightData implements Serializable {
        public double delay;
        public int countAll;
        public int canceledKol;
        public int kolFlightWDelay;
    FlightData(JavaPairRDD<String[]> FlightStr){
        delay = FlightStr[18]

    }
}
