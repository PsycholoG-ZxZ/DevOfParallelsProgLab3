package AirportsAndDelaysPack;
import org.apache.spark.api.java.JavaRDD;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;


public class AirportsAndDelaysApp {
    public static void main (String[] args){
        SparkConf conf = new SparkConf().setAppName("lab5");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> Airports = sc.textFile("/home/dmitry/ParallLab3/DevOfParallelsProgLab3/MergeAirShowDelay/SMALL.csv");
        JavaRDD<String> Delays = sc.textFile("/home/dmitry/ParallLab3/DevOfParallelsProgLab3/MergeAirShowDelay/BIG.csv");
        String AirString = Airports.toString();
        String[] data = AirString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        val RddArr = Airports.map(x => )
    }

}
