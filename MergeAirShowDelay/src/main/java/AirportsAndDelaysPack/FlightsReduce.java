package AirportsAndDelaysPack;

import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

public class FlightsReduce {
    public static JavaPairRDD<Tuple2, Tuple2> FlightsCount (JavaPairRDD<Tuple2<String,String>, FlightData> TupleWithKey,
                                                            )
}
