import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;
//import java.lang.*;


public class ConsoleMenu{



    public static void printMenu(String[] options){
        for(String option: options){
            System.out.println(option);
        }
        System.out.println("Choose your option ");
    }
    public static void  optionWorking(){
        String[] options = {"enter 0 to filter product list by catagory",
                "enter 1 to filter product list by brand",
                "enter 2 to filter product list by availability",
                "enter 3 to filter product list by price range",
                " ",
                "enter 4 to sort product list by name",
                "enter 5 to sort product list by price (low to high)",
                "enter 6 to sort product list by price (high to low)",
                "enter 7 to purchase a product",
                "enter 8 to exit application"
        };
        Scanner sc = new Scanner(System.in);
        int option = 0;

        while(option != 8 && option < 8){
            printMenu(options);

            try{
                option = sc.nextInt();
                switch(option){
                    case 0: option0();

                        continueOption();

                        break;
                    case 1: option1();
                        continueOption();
                        break;
                    case 2: option2();
                        continueOption();
                        break;
                    case 3: option3();
                        continueOption();
                        break;
                    case 4: option4();
                        continueOption();
                        break;
                    case 5: option5();
                        continueOption();
                        break;
                    case 6: option6();
                        continueOption();
                        break;
                    case 7: option7();
                        continueOption();
                        break;

                    case 8: System.exit(0);
                    default: printMenu(options);

                }

            }
            catch(InputMismatchException iex){
                System.out.println("Enter a value between 1 and "+ options.length);
                sc.next();
            }
            catch(Exception e){
                System.out.println("Unexpected Error. Please try again later");
                sc.next();
            }
        }
    }

    public static void continueOption(){
        String[] options = {"enter 0 to filter product list by catagory",
                "enter 1 to filter product list by brand",
                "enter 2 to filter product list by availability",
                "enter 3 to filter product list by price range",
                " ",
                "enter 4 to sort product list by name",
                "enter 5 to sort product list by price (low to high)",
                "enter 6 to sort product list by price (high to low)",
                "enter 7 to purchase a product",
                "enter 8 to exit application"
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue? Yes/No");
        String str2 = sc.next();
        if(str2.equals("Yes") || str2.equals("yes") ){
            printMenu(options);
        }
        else{
            System.exit(0);
        }
    }

    private static void option0() throws IOException,FileNotFoundException{
        //ReadFromFile rff = new ReadFromFile();
        ReadFromFile.filterByCategory();
    }

    private static void option1() throws IOException, FileNotFoundException{
        
        ReadFromFile.filterByBrand();
    }

    private static void option2() throws IOException, FileNotFoundException{

        
        ReadFromFile.filterByAvailable();
    }

    private static void option3() throws IOException, FileNotFoundException{
        
        ReadFromFile.filterByPrice();
    }

    private static void option4() throws IOException, FileNotFoundException{
        
        ReadFromFile.sortByName();
    }

    private static void option5() throws IOException, FileNotFoundException{
        
        ReadFromFile.sortByLowToHigh();
    }

    private static void option6() throws IOException, FileNotFoundException{
        
        ReadFromFile.sortByHighToLow();
    }

    private static void option7() throws IOException, FileNotFoundException{
        

        ReadFromFile.purchase();
    }
}

