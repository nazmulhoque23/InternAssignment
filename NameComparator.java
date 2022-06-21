import java.util.*;

public class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2){
        int f = p1.getName().compareTo(p2.getName());
        
        return f;
    }
}
