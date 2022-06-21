import java.util.*;

public class HighToLow implements Comparator<Product>{
    public int compare(Product p1, Product p2){
        return (Double.compare(p2.getPrice(), p1.getPrice()));
    }
     
}
