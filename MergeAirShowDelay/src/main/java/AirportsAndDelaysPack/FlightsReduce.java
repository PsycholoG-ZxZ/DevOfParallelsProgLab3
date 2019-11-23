package AirportsAndDelaysPack;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class FlightsReduce {
    public static JavaPairRDD<Tuple2, Tuple2> FlightsCount (JavaPairRDD<Tuple2<String,String>, FlightData> TupleWithKey,
                                                            Broadcast<Map<String,String>> AirBroadcast){
        return TupleWithKey

    }
}
