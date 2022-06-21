public class Product{
    public enum Available{
        InStock,
        Upcoming,
        OutOfStock;

        

        public static Available getByName(String avail){
            Available[]  allAvail = Available.values();
            for(Available value: allAvail){
                if(value.name().equalsIgnoreCase(avail)){
                    return value;
                }
            }
            return null;
        }
    }
    int id;
    String name;
    String description;
    String category;
    String brand;
    double price;
    int amountInStock;
    Available avail;

    public Product(){}

    public Product(int id, String name, String description, String category, String brand, double price, int amountInStock, Available avail){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.amountInStock = amountInStock;
        this.avail = avail;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.description;
    }
    public String getCategory(){
        return this.category;
    }
    public String getBrand(){
        return this.brand;
    }
    public double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.amountInStock;
    }

    public Available getAvail(){
        return this.avail;
    }

    public String toString(){
        return (this.id+","+this.name+","+this.description+","+this.category+","+this.brand+","+this.price+","+this.amountInStock+","+this.avail);
    }
}