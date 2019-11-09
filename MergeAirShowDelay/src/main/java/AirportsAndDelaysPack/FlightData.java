package AirportsAndDelaysPack;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple1;
import scala.Tuple2;

import java.io.Serializable;

public class FlightData implements Serializable {
        public double delay;
        public int countAll;
        public int canceledKol;
        public int kolFlightWDelay;
    FlightData(Tuple2<String,String> delInfo) {
        countAll = 1;
        if (delInfo._2.equals("0")) {
            canceledKol = 0;
            if (delInfo._1 != "") {
                delay = Double.parseDouble(delInfo._1);
                kolFlightWDelay = 1;

            }
        } else {
            canceledKol = 1;
            delay = 0;
            kolFlightWDelay = 0;

        }
    }
}
