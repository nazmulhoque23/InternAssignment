import java.io.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.*;

public class ReadFromFile{
    public static List< Product> readFromFileData() throws IOException,FileNotFoundException, IllegalArgumentException{
            
            List< Product> products= new ArrayList<Product>();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String inputLine;
            try{


            while((inputLine = br.readLine())!=null){
                String [] data = inputLine.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String description = data[2];
                String category = data[3];
                String brand = data[4];
                double price = Double.parseDouble(data[5]);
                int amountInStock = Integer.parseInt(data[6]);
                String availValue = data[7];
                Product.Available avail = Product.Available.getByName(availValue);
                
                
                products.add(new Product(id, name, description, category, brand, price, amountInStock, avail));


                
            }
            
            
            br.close();
            
        }
            
            
        
        
        catch(InputMismatchException iex){
                System.out.println(iex);
        }
        return products;
       
    }

    //Reading data
    public static void readData() throws IOException, FileNotFoundException{
        
        List<Product> products= readFromFileData();

        System.out.println("Products");
        for(Product p : products){
            System.out.println(p.getId()+","+p.getName()+","+p.getDesc()+","+p.getCategory()+","+p.getBrand()+","+p.getPrice()+","+p.getStock()+","+p.getAvail());
        }
    }

    //Getting unique category
    public static void uniqueElements() throws IOException, FileNotFoundException{
        Set<String> categorySet = new HashSet<String>();
        
        List<Product> products= readFromFileData();

        for(Product p : products){
            
            categorySet.add(p.getCategory());   
            //System.out.println(p.getAvail());
        }

        System.out.println();
        System.out.println("Unique Categories: " + categorySet);

    }

    //filtering by cateory
    public static void filterByCategory() throws IOException, IllegalAccessError{
        
        List<Product> products = readFromFileData();

        List<String> filteredCategory = products.stream().map(p->p.getCategory()).collect(Collectors.toList());
        for(String s: filteredCategory){
            System.out.println(s);
        }
    }

    //filtering by brand
    public static void filterByBrand() throws IOException, IllegalAccessError{
        
        List<Product> products = readFromFileData();

        List<String> filterByBrand = products.stream().map(p->p.getBrand()).collect(Collectors.toList());
        for(String s: filterByBrand){
            System.out.println(s);
        }
    }

    //filtering by availability
    public static void filterByAvailable() throws IOException, IllegalAccessError{
        
        List<Product> products = readFromFileData();

        List<Product.Available> filteredByAvail = products.stream().map(p->p.getAvail()).collect(Collectors.toList());
        for(Product.Available s: filteredByAvail){
            System.out.println(s);
        }
    }

    //Filtering by price
    public static void filterByPrice() throws IOException, IllegalAccessError{
        
        List<Product> products = readFromFileData();

        List<Double> filteredPrice = products.stream().map(p->p.getPrice()).collect(Collectors.toList());
        for(Double s: filteredPrice){
            System.out.println(s);
        }
    }

    //Sorting by name
    public static void sortByName() throws IOException, IllegalAccessError{
        List<Product> products = readFromFileData();

        Collections.sort(products, new NameComparator());
        for(Product p: products){
            System.out.println(p.getName());
        }
    }

    //Sorting by low to high price
    public static void sortByLowToHigh() throws IOException, IllegalAccessError{
        List<Product> products = readFromFileData();

        Collections.sort(products, new LowToHighPrice());
        for(Product p: products){
            System.out.println(p.getPrice());
        }
    }
    //Sorting by high to low price
    public static void sortByHighToLow() throws IOException, IllegalAccessError{
        List<Product> products = readFromFileData();

        Collections.sort(products, new HighToLow());
        for(Product p: products){
            System.out.println(p.getPrice());
        }
    }

    
    public static void modifyFile(String filePath, String oldString, String newString)
    {
        String changeValue;
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replace(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public static void purchase() throws IOException, IllegalAccessError, NullPointerException{
        List<Product> products = readFromFileData();
        
        readData();
        
        FileWriter writer = new FileWriter("PurchaseLog.txt");
        
        System.out.println("Place Id and amount to buy"+"\n"+ "Put the 2nd value in a new line");
        
        
        Scanner sc = new Scanner(System.in);
            
        int input = sc.nextInt();
            
        int input2 = sc.nextInt();
        

        

        
        
        
        Date date = new Date();
            
        Date time = new Date(date.getTime());

        for(int i = 0; i< products.size(); i++){
                
            if(input == products.get(i).getId() && input2 < products.get(i).getStock()){
                    int id = input;
                    String  name = products.get(i).getName();
                    int quantity = input2;
                    double price = products.get(i).getPrice()*quantity;
                    
                    

                    //modifyFile("data.txt", q, cq);
                    
                    int amount = products.get(i).getStock();
                    //System.out.println(amount);
                    int modifiedAmount = amount-input2;
                    //System.out.println(modifiedAmount);
                    modifyFile("data.txt", String.valueOf(amount),String.valueOf(modifiedAmount));
                    writer.write("Purchase Time: "+ time+ ", "+ "id: "+ id+ ", "+"item name: "+name+", "+"quantity: "+ quantity+", "+"Price: "+price);
                    
                    writer.close();
                    
                    break;
                    
                     
                                

            }  
            
             
        }
}


    

    
        
}

