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
                    Double stat = Double.parseDouble(s[19]);
                    String del = s[18];
                    return new Tuple2<>(new Tuple2<>(
                            AirBroadcast.getValue().get(airFrom), AirBroadcast.getValue().get(airTo)),
                            new FlightData(new Tuple2<String,String> (del.toString(), stat.toString()));
                }
        ).reduceByKey(
                (FlightData frst, FlightData sec)-> new FlightData(
                        Math.max(frst.delay, sec.delay), frst.countAll + sec.countAll, frst.kolFlightWDelay + sec.kolFlightWDelay
                )
        ).

    }
}
