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
    FlightData(Tuple2<String,String> delInfo){
        delay = Integer.parseInt(delInfo._1);
        

    }
}
