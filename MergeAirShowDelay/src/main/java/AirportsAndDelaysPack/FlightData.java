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
        public int per;
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
    FlightData(double del, int count, int countAll1){
        delay = del;
        kolFlightWDelay = countAll1;
        countAll = count;
        //canceledKol = countAll;
        if(kolFlightWDelay != 0){
            per = (float)kolFlightWDelay * 100 / (float) countAll;
        }else per = 0;
    }
}
