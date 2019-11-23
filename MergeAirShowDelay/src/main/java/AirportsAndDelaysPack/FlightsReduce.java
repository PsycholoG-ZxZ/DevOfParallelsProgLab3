package AirportsAndDelaysPack;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class FlightsReduce {
    public static JavaPairRDD<Tuple2, Tuple2> FlightsCount (JavaRDD<String[]> TupleWithKey,
                                                            Broadcast<Map<String,String>> AirBroadcast
                                                            ){
        return TupleWithKey.mapToPair(
                (String[] s) -> {
                    String airFrom = s[11];
                    String airTo =  s[14];
                    
                }
        )

    }
}
