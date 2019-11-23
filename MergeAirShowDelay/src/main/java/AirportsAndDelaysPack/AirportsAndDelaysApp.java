package AirportsAndDelaysPack;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;


public class AirportsAndDelaysApp {
    public static void main (String[] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> Airports = sc.textFile("/home/dmitry/ParallLab3/DevOfParallelsProgLab3/MergeAirShowDelay/SMALL.csv");
        JavaRDD<String> Delays = sc.textFile("/home/dmitry/ParallLab3/DevOfParallelsProgLab3/MergeAirShowDelay/BIG.csv");
       // String AirString = Airports.toString();
       // String[] data = AirString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        JavaRDD<String[]> RddAirports = Airports.filter(str -> !str.startsWith("Code")).map(x -> x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
        JavaRDD<String[]> RddDelays = Delays.filter(str -> !str.startsWith("\"YEAR\"")).map(x -> x.split(","));

        JavaPairRDD<String, String> IdAndDescrPair = RddAirports.mapToPair(x -> {return new Tuple2<>(x[0].replace("\"", ""), x[1]); });
        //пара ключ-дескрипшн ключ по виду такой же как и в др табл

        JavaPairRDD<Tuple2<String,String>, FlightData> TupleWithKey = RddDelays.mapToPair(x -> {return new Tuple2<>(new Tuple2<String,String>(x[11], x[14]), new FlightData(new Tuple2<String,String>(x[18], x[19])));});
        Map<String,String> airportMap = IdAndDescrPair.collectAsMap();
        //избавимся от лишних и заколектим в мап ключ-дескр
        JavaRdd
        final Broadcast<Map<String,String>> AirBroadcast = sc.broadcast(airportMap);
        JavaPairRDD<Tuple2, Tuple2> Inf = FlightsReduce.FlightsCount(TupleWithKey, AirBroadcast);

    }

}
