// StreamReduction.java
// Demonstrate the use and functioning of the Stream API. In this ex. we will
// use a specific stream (IntStream) and loop at several operations on int streams.

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduction
{
   public static void main(String[] args)
   {
      // Source Array
      String[] stoogesArray0 = {"Larry", "Curly", "Moe"};
      
      System.out.printf("The stream source is the array: %s %n", Arrays.toString(stoogesArray0));
      // Variable for the stream
      Stream<String> stooges;
      
      // Get the stream and count
      stooges = Stream.of(stoogesArray0);
      System.out.printf("The count is %d%n", stooges.count());
      // Get the stream and reduce with forEach
      stooges= Stream.of(stoogesArray0);
      stooges.forEach(
      x -> {System.out.printf("%s has length %d%n", x, x.length());});
      
      System.out.println("The stream reduced to an array (2 ways): ");
      // Get a sream and reduce with toArray()
      // The first way
      stooges = Stream.of(stoogesArray0);
      String [] stoogesArray1 = stooges.toArray(x -> new String[x]);
      System.out.println(Arrays.toString(stoogesArray1));
      // The second way
      stooges = Stream.of(stoogesArray0);
      String[] stoogesArray2 = stooges.toArray(String[]::new);
      System.out.println(Arrays.toString(stoogesArray2));
      
      // Get a stream and reduce with min(2 ways)
      stooges = Stream.of(stoogesArray0);
      Optional<String> min = stooges.min((x, y) -> x.compareTo(y));
      System.out.printf("First stooge by alphabetical order: %s%n", min.get());
      
      stooges = Stream.of(stoogesArray0);
      Optional<String> min1 = stooges.min(String::compareTo);
      System.out.printf("First stooge by alphabetical order: %s%n", min1.get());
      
      // Get a stream and reduce with max(2 ways)
      stooges = Stream.of(stoogesArray0);
      Optional<String> max = stooges.max((x, y) -> x.compareTo(y));
      System.out.printf("First stooge by alphabetical order: %s%n", max.get());
      
      stooges = Stream.of(stoogesArray0);
      Optional<String> max1 = stooges.max(String::compareTo);
      System.out.printf("First stooge by alphabetical order: %s%n", max1.get());
      
      
   } // end main
   
} //end class