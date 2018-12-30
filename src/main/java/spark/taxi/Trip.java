package spark.taxi;

import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Trip {
    private transient String id;
    private int km;
    private String city;

    public static Trip fromLine(String line) {
        String[] arr = line.split(" ");
        return Trip.builder().id(arr[0]).city(arr[1]).km(Integer.parseInt(arr[2])).build();
    }

    @SneakyThrows
    public static void main(String[] args) {
        Trip trip = Trip.builder().id("1").city("Boston").km(12).build();
        File file = new File("c:\\temp\\trips.txt");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(trip);


    }


}







