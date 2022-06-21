import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
//import package.name.Product.Available;

class WriteDataToFile{
    public static void writeProductToData() throws Exception{


        Product.Available value= Product.Available.InStock;
        Product.Available value1 = Product.Available.Upcoming;
        Product.Available value2 = Product.Available.OutOfStock;

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Nokia C30", "Nokia C30 smart phone", "Mobile", "Nokia", 2500.00, 35, value));
        products.add(new Product(2, "Nokia C30", "Nokia C30 smart phone", "Mobile", "Nokia", 2500.00, 33, value));
        products.add(new Product(3, "Samsung Galaxy", "Samsung s22 smart phone", "Mobile", "Samsung", 3000.00, 34, value1));
        products.add(new Product(4, "Table", "Folding Table", "Furniture", "Otobi", 4000.00, 30, value1));
        products.add(new Product(5, "Suzuki Gixxer", "Sports bike", "Bike", "Suzuki", 10000, 20, value1));
        products.add(new Product(6, "Mercedes s220", "Mercedes S220 car", "Car", "Mercedes", 20000, 25, value1));
        
        FileWriter writer = null;
        try{
            writer = new FileWriter("data.txt");
            for(Product productList: products){
                writer.write(productList.toString());
                writer.append('\n');
            }
            writer.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        WriteDataToFile writing = new WriteDataToFile();
        writing.writeProductToData();
    }
}